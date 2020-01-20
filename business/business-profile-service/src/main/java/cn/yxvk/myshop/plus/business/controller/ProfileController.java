package cn.yxvk.myshop.plus.business.controller;

import cn.yxvk.myshop.plus.business.BusinessStatus;
import cn.yxvk.myshop.plus.business.dto.UmsAdminDTO;
import cn.yxvk.myshop.plus.business.dto.params.IconParam;
import cn.yxvk.myshop.plus.business.dto.params.ProfileParam;
import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import cn.yxvk.myshop.plus.provider.api.UmsAdminService;
import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangxiang
 * @date 2019/11/19 18:28
 */
@RestController
@RequestMapping("profile")
public class ProfileController {
    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @GetMapping("info/{username}")
    public ResponseResult<UmsAdminDTO> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.get(username);
        UmsAdminDTO dto=new UmsAdminDTO();
        BeanUtils.copyProperties(umsAdmin,dto);
        return new ResponseResult<>(BusinessStatus.OK.getCode(), "用户信息", dto);
    }

    @PostMapping("update")
    public ResponseResult update(@RequestBody ProfileParam profileParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(profileParam, umsAdmin);
        int result = umsAdminService.update(umsAdmin);
        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(BusinessStatus.OK.getCode(), "更新个人信息成功");
        }
        // 失败
        else {
            return new ResponseResult<Void>(BusinessStatus.FAIL.getCode(), "更新个人信息失败");
        }
    }

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "modify/icon")
    public ResponseResult<Void> modifyIcon(@RequestBody IconParam iconParam) {
        int result = umsAdminService.modifyIcon(iconParam.getUsername(), iconParam.getPath());
        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(BusinessStatus.OK.getCode(), "更新头像成功");
        }
        // 失败
        else {
            return new ResponseResult<Void>(BusinessStatus.FAIL.getCode(), "更新头像失败");
        }
    }
}
