package com.home.library.userservice.service;

import com.home.library.userservice.entity.SysUser;

import java.util.List;

public interface SysUserService {
    /**
     * 用户名查询
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

    /**
     * 查询全部
     * @return
     */
    List<SysUser> findAll();

    void regin (SysUser sysUser);
}
