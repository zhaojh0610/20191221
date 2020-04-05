package com.zjh.usercenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaojh
 * @CreateTime 2020/3/11 15:41
 * @Version 1.0
 * @Desc 用户登录信息
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginDTO {
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * code
     */
    private String code;
    /**
     * 微信昵称
     */
    private String wxNickname;
}
