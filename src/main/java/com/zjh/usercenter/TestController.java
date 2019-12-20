package com.zjh.usercenter;

import com.zjh.usercenter.dao.user.UserMapper;
import com.zjh.usercenter.domain.entity.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/10/14 8:44
 */
@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/test")
    public User testInset(){
        User user = new User();
        user.setAvatarUrl("xxx");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        this.userMapper.insertSelective(user);
        return user;
    }


}
