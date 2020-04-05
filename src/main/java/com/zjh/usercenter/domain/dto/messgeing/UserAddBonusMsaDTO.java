package com.zjh.usercenter.domain.dto.messgeing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName UserAddBonusMsaDTO
 * @Author zhaojh
 * @Date 2020/1/12 9:39
 * @Version 1.0
 * @Description //TODO
 **/
@Data
@Builder
@AllArgsConstructor
public class UserAddBonusMsaDTO {
    /**
     * 为谁加分
     */
    private Integer userId;
    /**
     * 加多少分
     */
    private Integer bonus;
    /**
     * 发生的事件
     */
    private String event;
    /**
     * 描述
     */
    private String description;
}
