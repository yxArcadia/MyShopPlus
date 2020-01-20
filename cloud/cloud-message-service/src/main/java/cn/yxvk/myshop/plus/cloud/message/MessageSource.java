package cn.yxvk.myshop.plus.cloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author yangxiang
 * @date 2020/1/14 14:15
 */

public interface MessageSource {

    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();
}
