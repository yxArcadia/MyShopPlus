package cn.yxvk.myshop.plus.cloud.prodcer;

import cn.yxvk.myshop.plus.api.MessageService;
import cn.yxvk.myshop.plus.cloud.message.MessageSource;
import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yangxiang
 * @date 2020/1/14 14:17
 */
@Component
@Service(version = "1.0.0")
public class MessageProducer  implements MessageService {
    @Resource
    private MessageSource source;
    /**
     * 管理登录日志
     *
     * @param dto {@link UmsAdminLoginLogDTO}
     * @return {@code boolean}
     */
    @Override
    public boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
    }
}
