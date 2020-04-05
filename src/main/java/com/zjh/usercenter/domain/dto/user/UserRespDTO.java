package com.zjh.usercenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaojh
 * @CreateTime 2020/3/11 15:27
 * @Version 1.0
 * @Desc 用户响应DTO
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class UserRespDTO {
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 积分
     */
    private Integer bonus;
    /**
     * id
     */
    private Integer id;
    /**
     * 微信昵称
     */
    private String wxNickname;
}
