package com.home.library.resourcesservice.service;

import com.home.library.resourcesservice.entity.UserEntity;

import java.util.List;

public interface UserService {

    /**
     * 插入用户测试数据
     * @return
     */
    void addUserData(UserEntity userEntity);

    /**
     * 查询全部测试用户
     * @return
     */
    List<UserEntity> getAllUserData();
}
