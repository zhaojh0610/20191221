package com.zjh.usercenter.rocketmq;

import com.zjh.usercenter.domain.dto.messgeing.UserAddBonusMsaDTO;
import com.zjh.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestStreamConsumer
 * @Author zhaojh
 * @Date 2020/1/21 10:42
 * @Version 1.0
 * @Description //TODO
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusStreamConsumer {
    private final UserService userService;

    @StreamListener(Sink.INPUT)
    private void receive(UserAddBonusMsaDTO message) {
        this.userService.addBonus(message);
    }


}


