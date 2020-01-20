package cn.yxvk.myshop.plus.provider.service;

import cn.yxvk.myshop.plus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yangxiang
 * @date 2019/11/13 17:28
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String str) {
        return "hello "+str;
    }
}
