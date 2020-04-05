package com.zjh.usercenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaojh
 * @CreateTime 2020/3/11 15:35
 * @Version 1.0
 * @Desc 登录响应DTO
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRespDTO {
    /**
     * token信息
     */
    private JwtTokenRespDTO token;
    /**
     * 用户信息
     */
    private UserRespDTO user;
}
