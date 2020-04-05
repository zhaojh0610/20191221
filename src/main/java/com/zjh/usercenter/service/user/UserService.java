package com.zjh.usercenter.service.user;

import com.zjh.usercenter.dao.bonusEventLog.BonusEventLogMapper;
import com.zjh.usercenter.dao.user.UserMapper;
import com.zjh.usercenter.domain.dto.messgeing.UserAddBonusMsaDTO;
import com.zjh.usercenter.domain.dto.user.UserLoginDTO;
import com.zjh.usercenter.domain.entity.bonusEventLog.BonusEventLog;
import com.zjh.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zhaojh
 * @version 1.0
 * @date 2019/11/30 10:03
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    /**
     * 根据ID查询指定用户的信息
     *
     * @param id
     * @return
     */
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBonus(UserAddBonusMsaDTO message) {
        //setp1:为用户加积分
        User user = userMapper.selectByPrimaryKey(message.getUserId());
        Integer bonus = message.getBonus();
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKey(user);
        //step2：记录日志到bonus_event_log
        this.bonusEventLogMapper.insert(BonusEventLog
                .builder()
                .userId(user.getId())
                .value(bonus)
                .event(message.getEvent())
                .createTime(new Date())
                .description(message.getDescription())
                .build());
        log.info("积分添加完毕...");
    }

    public User login(UserLoginDTO loginDTO,String openId) {
        User user = userMapper.selectOne(User.builder().wxId(openId).build());
        if (user == null) {
            User userToSave = User.builder()
                    .wxId(openId)
                    .bonus(300)
                    .wxNickname(loginDTO.getWxNickname())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .roles("user")
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            userMapper.insertSelective(userToSave);
            return userToSave;
        }
        return user;
    }

}
