package cn.yxvk.myshop.plus.business.controller;

import cn.yxvk.myshop.plus.api.MessageService;
import cn.yxvk.myshop.plus.business.BusinessException;
import cn.yxvk.myshop.plus.business.BusinessStatus;
import cn.yxvk.myshop.plus.business.dto.LoginInfo;
import cn.yxvk.myshop.plus.business.dto.LoginParam;
import cn.yxvk.myshop.plus.business.feign.ProfileFeign;
import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import cn.yxvk.myshop.plus.commons.utils.MapperUtils;
import cn.yxvk.myshop.plus.commons.utils.OkHttpClientUtil;
import cn.yxvk.myshop.plus.commons.utils.UserAgentUtils;
import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;
import cn.yxvk.myshop.plus.feign.MessageFeign;
import cn.yxvk.myshop.plus.provider.api.UmsAdminService;
import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangxiang
 * @date 2019/11/18 17:37
 */
@RestController
public class LoginController {
    private static final String URL_OAUTH_TOKEN="http://localhost:9001/oauth/token";
    @Value("${business.oauth2.grant_type}")
    public String grantType;
    @Value("${business.oauth2.client_id}")
    public String clientId;
    @Value("${business.oauth2.client_secret}")
    public String clientSecret;
    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    public TokenStore tokenStore;
    @Resource
    private ProfileFeign profileFeign;
    @Reference(version = "1.0.0")
    private MessageService messageService;
    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;
    @ApiOperation(value = "管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "int", paramType = "path"),
    })
    @PostMapping("user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParam loginParam,HttpServletRequest request){
        Map<String,Object> result=new HashMap<>(5);
        //验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails==null || !passwordEncoder.matches(loginParam.getPassword(),userDetails.getPassword())){
            throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
        }
        OkHttpClientUtil instance = OkHttpClientUtil.getInstance();
        Map<String,String> params=new HashMap<>();
        params.put("username",loginParam.getUsername());
        params.put("password",loginParam.getPassword());
        params.put("grant_type",grantType);
        params.put("client_id",clientId);
        params.put("client_secret",clientSecret);
        Response response = instance.postData(URL_OAUTH_TOKEN, params);
        try {
            String json= Objects.requireNonNull(response.body()).string();
            Map<String, Object> map = MapperUtils.json2map(json);
            String token=map.get("access_token").toString();
            result.put("token",token);
        } catch (Exception e) {
            throw new BusinessException(BusinessStatus.ILLEGAL_TOKEN);
        }
        //发送登录日志消息
        boolean s = sendAdminLoginLog(userDetails.getUsername(), request);
        return new ResponseResult<Map<String, Object>>(BusinessStatus.OK.getCode(), "登录成功", result);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("user/get_info")
    public ResponseResult info() throws Exception {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String jsonString = profileFeign.info(authentication.getName());
        UmsAdmin umsAdmin = MapperUtils.json2pojoByTree(jsonString, "data", UmsAdmin.class);
        if (umsAdmin.getUsername()==null){
            throw new BusinessException(BusinessStatus.FAIL);
        }
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setName(umsAdmin.getUsername());
        loginInfo.setAccess(new String[]{"admin"});
        loginInfo.setAvatar(umsAdmin.getIcon());
        loginInfo.setUserId(umsAdmin.getId().toString());
        return new ResponseResult<>(BusinessStatus.OK.getCode(),"获取用户信息",loginInfo);
    }
    @PostMapping("user/logout")
    public ResponseResult logout(HttpServletRequest request){
        String accessToken = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<>(BusinessStatus.OK.getCode(),"用户注销",null);
    }

    /**
     * 发送登录消息到rocketmq
     * @param userName 用户名
     * @param request 请求对象
     * @return 发送消息结果
     */
    private boolean sendAdminLoginLog(String userName,HttpServletRequest request){
        UmsAdminLoginLogDTO dto=new UmsAdminLoginLogDTO();
        UmsAdmin umsAdmin = umsAdminService.get(userName);
        String ip=UserAgentUtils.getIpAddr(request);
        dto.setAdminId(umsAdmin.getId());
        dto.setCreateTime(new Date());
        dto.setIp(ip);
        dto.setAddress(UserAgentUtils.getIpInfo(ip).getCity());
        dto.setUserAgent(UserAgentUtils.getBrowser(request).getName());
        return messageService.sendAdminLoginLog(dto);
    }
}
