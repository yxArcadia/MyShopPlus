package cn.yxvk.myshop.plus.business;

import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局自定义异常业务处理
 * @author yangxiang
 * @date 2020/1/15 18:41
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handlerException(HttpServletRequest request, Exception ex) {
        ResponseResult error = new ResponseResult();
        // 业务异常
        if (ex instanceof BusinessException) {
            error.setState(((BusinessException) ex).getCode());
            error.setMessage(ex.getMessage());
            log.warn("[全局业务异常]\r\n业务编码：{}\r\n异常记录：{}", error.getState(), error.getMessage());
        }
        // 未知错误
        else {
            error.setState(BusinessStatus.UNKNOWN.getCode());
            error.setMessage(BusinessStatus.UNKNOWN.getMessage());
        }
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
