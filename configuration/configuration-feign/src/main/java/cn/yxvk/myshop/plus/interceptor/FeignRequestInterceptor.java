package cn.yxvk.myshop.plus.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @author yangxiang
 * @date 2019/11/20 10:03
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()){
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                requestTemplate.header(name,value);
            }
        }
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder body=new StringBuilder();
        if (parameterNames != null) {
            while (parameterNames.hasMoreElements()){
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);
                if (name.equals("access_token")){
                    requestTemplate.header("authorization","Bearer"+value);
                }else {
                    body.append(name).append("=").append(value).append("&");
                }
            }
        }
        if (body.toString().length()>0){
            body.deleteCharAt(body.length()-1);
            requestTemplate.body(Request.Body.bodyTemplate(body.toString(), Charset.defaultCharset()));
        }
    }
}
