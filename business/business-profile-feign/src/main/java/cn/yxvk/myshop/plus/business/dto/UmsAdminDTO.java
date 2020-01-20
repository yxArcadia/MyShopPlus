package cn.yxvk.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangxiang
 * @date 2019/12/13 9:46
 */
@Data
public class UmsAdminDTO implements Serializable {
    private static final long serialVersionUID = -6637081769654900524L;

    private Long id;

    private String username;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Date createTime;

    private Date loginTime;

    private Integer status;
}
