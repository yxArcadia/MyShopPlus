package cn.yxvk.myshop.plus.feign;

import cn.yxvk.myshop.plus.configuration.FeignRequestConfiguration;
import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;
import cn.yxvk.myshop.plus.feign.fallback.MessageFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangxiang
 * @date 2020/1/9 17:22
 */
@FeignClient(value = "cloud-message",path = "message",
        configuration = FeignRequestConfiguration.class,
        fallback = MessageFeignFallback.class)
public interface MessageFeign {

    @PostMapping(value = "admin/login/log")
    public String sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO umsAdminLoginLogDTO);
}
