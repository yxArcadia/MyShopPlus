package cn.yxvk.myshop.plus.business.controller;

import cn.yxvk.myshop.plus.business.BusinessStatus;
import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import cn.yxvk.myshop.plus.provider.api.UmsAdminService;
import cn.yxvk.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangxiang
 * @date 2019/11/14 10:54
 */
@RestController
@RequestMapping("reg")
public class RegController {
    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    /**
     * 注册
     * @param umsAdmin {@link UmsAdmin}
     * @return 结果
     */
    @PostMapping(value = "")
    public ResponseResult<UmsAdmin> reg(@RequestBody UmsAdmin umsAdmin){
        String msg = validateReg(umsAdmin);
        if (msg==null){
            Integer integer = umsAdminService.inserUmsAdmin(umsAdmin);
            if (integer>0){
                return new ResponseResult<>(BusinessStatus.OK.getCode(),"用户注册成功");
            }else {
                return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"用户注册失败");
            }
        }else {
            return new ResponseResult<>(BusinessStatus.FAIL.getCode(),msg);
        }
    }

    /**
     * 注册信息验证
     * @param umsAdmin {@link UmsAdmin}
     * @return 验证结果
     */
    private String validateReg(UmsAdmin umsAdmin){
        UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
        if (admin!=null){
            return "用户名已存在,请重新输入";
        }
        return null;
    }
}
