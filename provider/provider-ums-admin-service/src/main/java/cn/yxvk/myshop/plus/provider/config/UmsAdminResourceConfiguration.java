package cn.yxvk.myshop.plus.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yangxiang
 * @date 2019/11/14 10:20
 */
@Configuration
public class UmsAdminResourceConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
