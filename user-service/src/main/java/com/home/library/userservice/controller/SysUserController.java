package com.home.library.userservice.controller;

import com.home.library.userservice.call.upload.service.UploadServiceFeign;
import com.home.library.userservice.entity.FileEntity;
import com.home.library.userservice.entity.SysUserEntity;
import com.home.library.userservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;
    //调用上传文件服务接口
    @Autowired
    UploadServiceFeign uploadServiceFeign;

    @GetMapping(value = "getUserAll")
    public List<SysUserEntity> UserAll(){
        return sysUserService.findAll();
    }

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(value = "file") MultipartFile file){
        return uploadServiceFeign.uploadImage(file);
    }

    @RequestMapping(value = "getUploadAll")
    public List<FileEntity> UploadAll(){
        return uploadServiceFeign.findAllUpload();
    }

}