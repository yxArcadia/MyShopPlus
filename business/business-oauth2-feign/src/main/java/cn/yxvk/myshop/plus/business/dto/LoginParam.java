package cn.yxvk.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录参数类
 * @author yangxiang
 * @date 2019/11/18 17:39
 */
@Data
public class LoginParam implements Serializable {
    private static final long serialVersionUID = -1764273856906691941L;
    private String username;
    private String password;
}
