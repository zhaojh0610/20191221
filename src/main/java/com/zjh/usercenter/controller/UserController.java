package com.zjh.usercenter.controller;

import com.zjh.usercenter.domain.entity.user.User;
import com.zjh.usercenter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/12/18 23:34
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/find/{id}")
    public User findById(Integer id){
        return userService.findById(id);
    }
}
