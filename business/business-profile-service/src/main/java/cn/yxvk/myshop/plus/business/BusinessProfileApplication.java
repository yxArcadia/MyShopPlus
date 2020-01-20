package cn.yxvk.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangxiang
 * @date 2019/11/19 17:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessProfileApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessProfileApplication.class,args);
    }
}
