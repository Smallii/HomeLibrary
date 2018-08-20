package com.home.library.userservice.call.upload.service.fallback;

import com.home.library.userservice.call.upload.service.UploadServiceFeign;
import com.home.library.userservice.entity.FileEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class UploadServiceFallback implements UploadServiceFeign {
    @Override
    public String uploadImage(MultipartFile file) {
        return "上传文件服务接口调用失败！";
    }

    @Override
    public List<FileEntity> findAllUpload() {
        return null;
    }
}
