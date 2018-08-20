package com.home.library.resourcesservice.controller;

import com.home.library.resourcesservice.entity.UserEntity;
import com.home.library.resourcesservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user_data")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "add_user_data")
    public String addUserData(UserEntity userEntity){
        userService.addUserData(userEntity);
        return "添加成功！";
    }

    @GetMapping(value = "get_user_data_all")
    public List<UserEntity> userDataAll(){
        return userService.getAllUserData();
    }
}
