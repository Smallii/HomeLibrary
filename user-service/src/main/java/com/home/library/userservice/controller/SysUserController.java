package com.home.library.userservice.controller;

import com.home.library.userservice.call.upload.service.UploadServiceFeign;
import com.home.library.userservice.entity.FileEntity;
import com.home.library.userservice.entity.SysUser;
import com.home.library.userservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;
    //调用上传文件服务接口
    @Autowired
    UploadServiceFeign uploadServiceFeign;

    @PostMapping(value = "/regin")
    public String regin(SysUser sysUser) {
        sysUserService.regin(sysUser);
        return "注册成功！";
    }

    @GetMapping(value = "getUserAll")
    public List<SysUser> UserAll(){
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

    @PostMapping(value = "setSession")
    public String insertSession(HttpServletRequest request) {
        request.getSession().setAttribute("userSession",1);
        return "添加Session成功！";
    }

    @GetMapping(value = "getSession")
    public String selectSession(HttpServletRequest request) {
        int session = (int)request.getSession().getAttribute("userSession");

        return "获取Session成功！"+ session;
    }

}
