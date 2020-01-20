package cn.yxvk.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangxiang
 * @date 2019/11/19 11:10
 */
@Data
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 2525522707084457877L;
    private String avatar;
    private String[] access;
    private String name;
    private String userId;
}
