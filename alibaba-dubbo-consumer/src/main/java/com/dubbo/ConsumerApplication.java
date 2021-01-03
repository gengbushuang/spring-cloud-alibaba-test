package com.dubbo;

import com.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

    @Reference(url="dubbo://172.30.111.173:22222/com.dubbo.service.IUserService")
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @Bean
    public ApplicationRunner runner(){
        return args->System.out.println(userService.getNameById("Mic"));
    }
}
