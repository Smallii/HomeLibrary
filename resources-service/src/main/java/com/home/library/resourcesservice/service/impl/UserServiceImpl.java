package com.home.library.resourcesservice.service.impl;

import com.home.library.resourcesservice.dao.impl.UserRepository;
import com.home.library.resourcesservice.entity.UserEntity;
import com.home.library.resourcesservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUserData(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserData() {
        return userRepository.findAll();
    }
}
