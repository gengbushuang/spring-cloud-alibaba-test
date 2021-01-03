package com.dubbo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ConfigTest {

    @Bean
    public ConfBean tt(){
        return new ConfBean();
    }
}
