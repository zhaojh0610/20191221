package com.zjh.usercenter.service.user;

import com.zjh.usercenter.dao.user.UserMapper;
import com.zjh.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/11/30 10:03
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
