package com.home.library.userservice.service.impl;

import com.home.library.userservice.dao.SysUserRepository;
import com.home.library.userservice.entity.SysUser;
import com.home.library.userservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    //    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public void regin(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserRepository.save(sysUser);
    }
}
