package cn.yxvk.myshop.plus.provider.api;

import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;

/**
 * @author yangxiang
 * @date 2019/11/14 9:56
 */
public interface UmsAdminService {
    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 插入条数
     */
    Integer inserUmsAdmin(UmsAdmin umsAdmin);

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 用户信息
     */
    UmsAdmin get(String username);

    /**
     * 查询用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 用户信息
     */
    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新用户
     * @param umsAdmin  {@link UmsAdmin}
     * @return 修改条数
     */
    Integer update(UmsAdmin umsAdmin);

    /**
     * 修改头像
     *
     * @param username {@code String} 用户名
     * @param path     {@code String} 头像地址
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyIcon(String username, String path);
}
