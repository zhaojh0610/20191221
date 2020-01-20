package com.zjh.usercenter.rocketmq;

import com.zjh.usercenter.dao.bonusEventLog.BonusEventLogMapper;
import com.zjh.usercenter.dao.user.UserMapper;
import com.zjh.usercenter.domain.dto.messgeing.UserAddBonusMsaDTO;
import com.zjh.usercenter.domain.entity.bonusEventLog.BonusEventLog;
import com.zjh.usercenter.domain.entity.user.User;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName AddBonusListener
 * @Author zhaojh
 * @Date 2020/1/12 20:38
 * @Version 1.0
 * @Description //TODO
 **/
@Slf4j
@Service
@RocketMQMessageListener(topic = "add-bonus", consumerGroup = "consumer-group")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusListener implements RocketMQListener<UserAddBonusMsaDTO> {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsaDTO userAddBonusMsaDTO) {
        //setp1:为用户加积分
        User user = userMapper.selectByPrimaryKey(userAddBonusMsaDTO.getUserId());
        Integer bonus = userAddBonusMsaDTO.getBonus();
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKey(user);
        //step2：记录日志到bonus_event_log
        this.bonusEventLogMapper.insert(BonusEventLog
                .builder()
                .userId(user.getId())
                .value(bonus)
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build());
        log.info("积分添加完毕...");
    }
}
