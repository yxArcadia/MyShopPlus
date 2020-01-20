package cn.yxvk.myshop.plus.provider;

import cn.yxvk.myshop.plus.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yangxiang
 * @date 2020/1/7 16:17
 */
@SpringBootApplication(scanBasePackageClasses = {ProviderUmsAdminLoginLogApplication.class, DubboSentinelConfiguration.class})
@MapperScan("cn.yxvk.myshop.plus.provider.mapper")
public class ProviderUmsAdminLoginLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUmsAdminLoginLogApplication.class,args);
    }
}
