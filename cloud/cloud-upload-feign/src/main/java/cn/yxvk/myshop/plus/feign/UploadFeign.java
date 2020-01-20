package cn.yxvk.myshop.plus.feign;

import cn.yxvk.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangxiang
 * @date 2019/11/26 18:13
 */
@FeignClient(value = "cloud-upload", path = "upload", configuration = FeignRequestConfiguration.class)
public interface UploadFeign {
    /**
     * 文件上传
     *
     * @param multipartFile {@code MultipartFile}
     * @return {@code String} 文件上传路径
     */
    @PostMapping(value = "")
    String upload(@RequestPart(value = "multipartFile") MultipartFile multipartFile);
}