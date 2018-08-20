package com.home.library.userservice.service.impl;

import com.home.library.userservice.dao.SysUserRepository;
import com.home.library.userservice.entity.SysUserEntity;
import com.home.library.userservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public SysUserEntity findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }

    @Override
    public List<SysUserEntity> findAll() {
        return sysUserRepository.findAll();
    }
}
