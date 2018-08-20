package com.home.library.uploadservice.service;

import com.home.library.uploadservice.entity.FileEntity;

import java.util.List;

public interface UploadService {

    /**
     * 上传图片
     * @return
     */
    void UploadImage(FileEntity fileEntity);

    /**
     * 获取全部文件
     * @return
     */
    List<FileEntity> getFileAll();
}
