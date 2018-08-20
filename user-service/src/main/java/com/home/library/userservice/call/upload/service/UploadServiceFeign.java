package com.home.library.userservice.call.upload.service;

import com.home.library.userservice.call.upload.service.fallback.UploadServiceFallback;
import com.home.library.userservice.entity.FileEntity;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "upload-service",fallback = UploadServiceFallback.class, configuration = UploadServiceFeign.MultipartSupportConfig.class)
public interface UploadServiceFeign {

    @PostMapping(value = "/upload/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadImage(@RequestPart(value = "file") MultipartFile file);

//    @GetMapping(value = "/upload/get_file_all")
    @RequestMapping(value = "/upload/get_file_all")
    List<FileEntity> findAllUpload();

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
