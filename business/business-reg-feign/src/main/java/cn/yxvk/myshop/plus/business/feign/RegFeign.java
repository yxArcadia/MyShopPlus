package cn.yxvk.myshop.plus.business.feign;

import cn.yxvk.myshop.plus.configuration.FeignRequestConfiguration;
import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangxiang
 * @date 2019/12/13 10:38
 */
@FeignClient(value = "business-reg",path = "reg",
        configuration = FeignRequestConfiguration.class)
public interface RegFeign {
    /**
     * 注册
     * @param umsAdmin {@link UmsAdmin}
     * @return 结果
     */
    @PostMapping(value = "")
    String reg(@RequestBody UmsAdmin umsAdmin);
}
