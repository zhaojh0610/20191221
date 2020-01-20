package com.zjh.usercenter.service.user;

import com.zjh.usercenter.dao.user.UserMapper;
import com.zjh.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/11/30 10:03
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper;

    /**
     * 根据ID查询指定用户的信息
     * @param id
     * @return
     */
    public User findById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
