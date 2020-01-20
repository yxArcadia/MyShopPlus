package cn.yxvk.myshop.plus.provider.service.fallback;

import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户服务提供者熔断
 * @author yangxiang
 * @date 2019/12/13 16:10
 */
public class UmsAdminServiceFallback {
    private static final Logger logger= LoggerFactory.getLogger(UmsAdminServiceFallback.class);

    public static UmsAdmin getByUsernameFallback(String username,Throwable ex){
        logger.warn("invoke getByUsernameFallback: "+ ex.getClass().getTypeName());
        return null;
    }
}
