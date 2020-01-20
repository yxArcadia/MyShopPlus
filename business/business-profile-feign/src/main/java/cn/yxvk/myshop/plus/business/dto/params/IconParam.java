package cn.yxvk.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangxiang
 * @date 2019/11/27 17:07
 */
@Data
public class IconParam implements Serializable {
    private static final long serialVersionUID = 9214748190332593755L;
    private String username;
    private String path;
}
