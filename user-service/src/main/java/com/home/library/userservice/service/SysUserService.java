package com.home.library.userservice.service;

import com.home.library.userservice.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    /**
     * 用户名查询
     * @param username
     * @return
     */
    SysUserEntity findByUsername(String username);

    /**
     * 查询全部
     * @return
     */
    List<SysUserEntity> findAll();
}
