package com.zjh.usercenter.controller;

import com.zjh.usercenter.domain.dto.messgeing.UserAddBonusMsaDTO;
import com.zjh.usercenter.domain.dto.user.UserAndBonusDTO;
import com.zjh.usercenter.domain.entity.user.User;
import com.zjh.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaojh
 * @CreateTime 2020/4/5 10:31
 * @Version 1.0
 * @Desc
 **/
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class bonusController {
    private final UserService userService;

    @PutMapping("/add-bonus")
    public User addBonus(@RequestBody UserAndBonusDTO userAndBonusDTO) {
        Integer userId = userAndBonusDTO.getUserId();
        userService.addBonus(
                UserAddBonusMsaDTO.builder()
                        .userId(userId)
                        .bonus(userAndBonusDTO.getBonus())
                        .event("buy")
                        .description("兑换分享...")
                        .build());

        return this.userService.findById(userId);
    }


}
