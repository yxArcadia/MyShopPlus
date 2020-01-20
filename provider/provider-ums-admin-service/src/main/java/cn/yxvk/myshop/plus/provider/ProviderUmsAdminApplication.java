package cn.yxvk.myshop.plus.provider;

import cn.yxvk.myshop.plus.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yangxiang
 * @date 2019/11/13 17:26
 */
@SpringBootApplication(scanBasePackageClasses = {ProviderUmsAdminApplication.class, DubboSentinelConfiguration.class})
@MapperScan("cn.yxvk.myshop.plus.provider.mapper")
public class ProviderUmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUmsAdminApplication.class,args);
    }
}
