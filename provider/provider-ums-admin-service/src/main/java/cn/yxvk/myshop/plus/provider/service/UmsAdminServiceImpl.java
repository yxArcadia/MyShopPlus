package cn.yxvk.myshop.plus.provider.service;

import cn.yxvk.myshop.plus.provider.api.UmsAdminService;
import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import cn.yxvk.myshop.plus.provider.mapper.UmsAdminMapper;
import cn.yxvk.myshop.plus.provider.service.fallback.UmsAdminServiceFallback;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yangxiang
 * @date 2019/11/14 10:05
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public Integer inserUmsAdmin(UmsAdmin umsAdmin) {
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    @SentinelResource(value = "getByUsername",fallback = "getByUsernameFallback",fallbackClass = UmsAdminServiceFallback.class)
    public UmsAdmin get(String username) {

        Example example=new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    @Override
    public Integer update(UmsAdmin umsAdmin) {
        UmsAdmin admin = get(umsAdmin.getUsername());
        admin.setEmail(umsAdmin.getEmail());
        admin.setNickName(umsAdmin.getNickName());
        admin.setNote(umsAdmin.getNote());
        admin.setStatus(umsAdmin.getStatus());
        return umsAdminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public int modifyIcon(String username, String path) {
        UmsAdmin umsAdmin = get(username);
        umsAdmin.setIcon(path);
        return umsAdminMapper.updateByPrimaryKey(umsAdmin);
    }

    /**
     * 初始化
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin){
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        if (umsAdmin.getStatus()==null){
            umsAdmin.setStatus(0);
        }
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }
}
