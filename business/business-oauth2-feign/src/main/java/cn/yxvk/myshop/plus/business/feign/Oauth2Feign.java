package cn.yxvk.myshop.plus.business.feign;

import cn.yxvk.myshop.plus.business.dto.LoginInfo;
import cn.yxvk.myshop.plus.business.dto.LoginParam;
import cn.yxvk.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangxiang
 * @date 2019/12/12 18:18
 */
@FeignClient(value = "business-oauth2",path = "oauth2",configuration = FeignRequestConfiguration.class)
public interface Oauth2Feign {
    @PostMapping("user/login")
    String login(@RequestBody LoginParam loginParam);

    @GetMapping("user/get_info")
    String info();

    @PostMapping("user/logout")
    String logout(HttpServletRequest request);
}
