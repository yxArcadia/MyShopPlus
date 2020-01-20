package cn.yxvk.myshop.plus.message;

import cn.yxvk.myshop.plus.message.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author yangxiang
 * @date 2020/1/14 17:58
 */
@SpringBootApplication
@EnableBinding({AdminLoginLogSink.class})
public class MessageAdminLoginLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageAdminLoginLogApplication.class,args);
    }
}
