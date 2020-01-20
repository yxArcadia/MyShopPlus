package cn.yxvk.myshop.plus.cloud.controller;

import cn.yxvk.myshop.plus.cloud.prodcer.MessageProducer;
import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangxiang
 * @date 2020/1/14 14:21
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Resource
    private MessageProducer messageProducer;
    @PostMapping(value = "admin/login/log")
    public ResponseResult<Void> sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO dto) {
        boolean flag = messageProducer.sendAdminLoginLog(dto);
        // 发送成功
        if (flag) {
            return new ResponseResult<Void>(HttpStatus.OK.value(), "管理员登录日志发送成功");
        }
        // 发送失败
        else {
            return new ResponseResult<Void>(HttpStatus.BAD_REQUEST.value(), "管理员登录日志发送失败");
        }
    }
}
