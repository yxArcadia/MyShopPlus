package cn.yxvk.myshop.plus.message.consumer;

import cn.yxvk.myshop.plus.commons.utils.MapperUtils;
import cn.yxvk.myshop.plus.provider.api.UmsAdminLoginLogService;
import cn.yxvk.myshop.plus.provider.domain.UmsAdminLoginLog;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author yangxiang
 * @date 2020/1/14 18:14
 */
@Service
public class AdminLoginLogReceive {

    @Reference(version = "1.0.0")
    private UmsAdminLoginLogService umsAdminLoginLogService;
    @StreamListener("admin-login-log-topic")
    public void receiveAdminLoginLog(String adminLoginLogJson) throws Exception {
        UmsAdminLoginLog umsAdminLoginLog = MapperUtils.json2pojo(adminLoginLogJson, UmsAdminLoginLog.class);
        umsAdminLoginLogService.insert(umsAdminLoginLog);
    }
}
