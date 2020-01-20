package cn.yxvk.myshop.plus.message.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author yangxiang
 * @date 2020/1/14 18:12
 */
public interface AdminLoginLogSink {
    /**
     * sink
     * @return 消息
     */
    @Input("admin-login-log-topic")
    SubscribableChannel adminLoginLog();
}
