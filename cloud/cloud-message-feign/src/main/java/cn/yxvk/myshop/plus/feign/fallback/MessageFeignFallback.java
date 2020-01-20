package cn.yxvk.myshop.plus.feign.fallback;

import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;
import cn.yxvk.myshop.plus.feign.MessageFeign;
import org.springframework.stereotype.Component;

/**
 * @author yangxiang
 * @date 2020/1/9 17:24
 */
@Component
public class MessageFeignFallback implements MessageFeign {
    @Override
    public String sendAdminLoginLog(UmsAdminLoginLogDTO umsAdminLoginLogDTO) {
        return "请求失败稍后重试";
    }
}
