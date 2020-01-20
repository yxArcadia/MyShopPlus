package cn.yxvk.myshop.plus.business.controller;

import cn.yxvk.myshop.plus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangxiang
 * @date 2019/11/14 9:38
 */
@RestController
@RequestMapping("echo")
public class EchoController {
    @Reference(version = "1.0.0")
    private EchoService echoService;

    @RequestMapping("/{msg}")
    public String echo(@PathVariable String msg){
        return echoService.echo(msg);
    }
}
