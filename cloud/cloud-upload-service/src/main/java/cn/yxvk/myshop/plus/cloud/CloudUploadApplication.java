package cn.yxvk.myshop.plus.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangxiang
 * @date 2019/11/26 18:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUploadApplication.class,args);
    }
}
