package com.home.library.resourcesservice.dao.impl;

import com.home.library.resourcesservice.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserEntity, Long> {

    /**
     * 重写，查询全部用户测试数据
     * @return
     */
    List<UserEntity> findAll();

}
