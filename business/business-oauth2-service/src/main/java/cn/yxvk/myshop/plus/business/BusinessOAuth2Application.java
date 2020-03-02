package cn.yxvk.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangxiang
 * @date 2019/11/14 17:24
 */
@SpringBootApplication(scanBasePackageClasses = {BusinessOAuth2Application.class},scanBasePackages = "cn.yxvk.myshop.plus.feign")
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class BusinessOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(BusinessOAuth2Application.class,args);
    }
}
