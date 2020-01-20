package cn.yxvk.myshop.plus.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangxiang
 * @date 2020/1/9 17:19
 */
@Data
public class UmsAdminLoginLogDTO implements Serializable {
    private static final long serialVersionUID = 2836472939971831061L;
    private Integer id;

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;

    private String userAgent;

}
