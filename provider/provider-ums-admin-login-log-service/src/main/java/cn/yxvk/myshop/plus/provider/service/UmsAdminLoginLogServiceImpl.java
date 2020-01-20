package cn.yxvk.myshop.plus.provider.service;

import javax.annotation.Resource;

import cn.yxvk.myshop.plus.provider.domain.UmsAdminLoginLog;
import cn.yxvk.myshop.plus.provider.mapper.UmsAdminLoginLogMapper;
import cn.yxvk.myshop.plus.provider.api.UmsAdminLoginLogService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author  yangxiang
 * @date  2020/1/7 17:02
 */
@Service(version = "1.0.0")
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService{

    @Resource
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    @Override
    public int insert(UmsAdminLoginLog umsAdminLoginLog) {
        return umsAdminLoginLogMapper.insert(umsAdminLoginLog);
    }
}
