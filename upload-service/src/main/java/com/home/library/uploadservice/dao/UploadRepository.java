package com.home.library.uploadservice.dao;

import com.home.library.uploadservice.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadRepository extends JpaRepository<FileEntity, Integer> {

    /**
     * 获取全部文件
     * @return
     */
    List<FileEntity> findAll();
}
