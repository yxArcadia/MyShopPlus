package cn.yxvk.myshop.plus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yangxiang
 * @date 2019/11/26 18:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 7001994384462930128L;
    /**
     * 文件路径
     */
    private String path;
}