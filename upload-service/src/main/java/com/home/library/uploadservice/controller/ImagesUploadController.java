package com.home.library.uploadservice.controller;

import com.home.library.uploadservice.entity.FileEntity;
import com.home.library.uploadservice.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "upload")
public class ImagesUploadController {

    @Autowired
    UploadService uploadService;

    /**
     * 上传图片到数据库
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@RequestPart(value = "file") MultipartFile file){
        System.out.println("我被调用了，我用来接受文件！我收到的文件名："+file.getName());
        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setUserId(2);
            fileEntity.setFile(file.getBytes());
            uploadService.UploadImage(fileEntity);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传文件失败");
        }
        return "调用文件上传接口成功！文件名："+file.getName();
    }

    /**
     * 获取全部文件
     * @return
     */
    @GetMapping(value = "get_file_all")
    public List<FileEntity> getFileAll(){
        return uploadService.getFileAll();
    }
}
