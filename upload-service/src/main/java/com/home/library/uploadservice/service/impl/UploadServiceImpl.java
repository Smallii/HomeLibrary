package com.home.library.uploadservice.service.impl;

import com.home.library.uploadservice.dao.UploadRepository;
import com.home.library.uploadservice.entity.FileEntity;
import com.home.library.uploadservice.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    UploadRepository uploadRepository;

    @Override
    public void UploadImage(FileEntity fileEntity) {
        uploadRepository.save(fileEntity);
    }

    @Override
    public List<FileEntity> getFileAll() {
        return uploadRepository.findAll();
    }
}
