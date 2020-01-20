package cn.yxvk.myshop.plus.api;

import cn.yxvk.myshop.plus.dto.UmsAdminLoginLogDTO;

/**
 * @author yangxiang
 * @date 2020/1/15 10:44
 */
public interface MessageService {
    boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto);
}
