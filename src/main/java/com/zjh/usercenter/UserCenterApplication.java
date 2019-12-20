package com.zjh.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhaojh
 * @date 2019年10月10日15:40:20
 * 扫描mybatis哪些包里面的接口
 */
@MapperScan("com.zjh")
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
