package cn.yxvk.myshop.plus.business.feign;

import cn.yxvk.myshop.plus.business.dto.params.IconParam;
import cn.yxvk.myshop.plus.business.dto.params.ProfileParam;
import cn.yxvk.myshop.plus.business.feign.fallback.ProfileFeignFallback;
import cn.yxvk.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangxiang
 * @date 2019/11/19 18:34
 */
@FeignClient(value = "business-profile",path = "profile",
        configuration = FeignRequestConfiguration.class,fallback = ProfileFeignFallback.class)
public interface ProfileFeign {
    /**
     * 获取用户信息
     * @param username 用户名
     * @return
     */
    @GetMapping("info/{username}")
    String info(@PathVariable String username);

    /**
     * 修改用户信息
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @PostMapping("update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);
}
