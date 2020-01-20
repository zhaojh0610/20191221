package com.zjh.usercenter.controller;

import com.zjh.usercenter.domain.entity.user.User;
import com.zjh.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/12/18 23:34
 */
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Integer id) {
        log.info("我被请求了。。。");
        return userService.findById(id);
    }

}
