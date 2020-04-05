package com.zjh.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhaojh
 * @date 2019年10月10日15:40:20
 * 扫描mybatis哪些包里面的接口
 */
@MapperScan("com.zjh")
@SpringBootApplication
@EnableBinding({Sink.class})
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    //在spring容器中创建一个对象，类型RestTemplate；名称/ID是
    // <bean id = "restTemplate" class = "xxx.RestTemplate" />
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
