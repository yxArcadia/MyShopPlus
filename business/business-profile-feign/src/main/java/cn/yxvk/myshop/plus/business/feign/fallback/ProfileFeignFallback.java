package cn.yxvk.myshop.plus.business.feign.fallback;

import cn.yxvk.myshop.plus.business.dto.UmsAdminDTO;
import cn.yxvk.myshop.plus.business.dto.params.IconParam;
import cn.yxvk.myshop.plus.business.dto.params.ProfileParam;
import cn.yxvk.myshop.plus.business.feign.ProfileFeign;
import cn.yxvk.myshop.plus.commons.dto.ResponseResult;
import cn.yxvk.myshop.plus.commons.utils.MapperUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 个人信息服务熔断
 * @author yangxiang
 * @date 2019/12/13 9:34
 */
@Component
public class ProfileFeignFallback implements ProfileFeign {
    @Override
    public String info(String username) {
        UmsAdminDTO dto=new UmsAdminDTO();
        dto.setEmail("yx@163.com");
        try {
            return MapperUtils.obj2json(new ResponseResult<UmsAdminDTO>(HttpStatus.BAD_REQUEST.value(),"触发熔断",dto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String update(ProfileParam profileParam) {
        return null;
    }

    @Override
    public String modifyIcon(IconParam iconParam) {
        return null;
    }
}
