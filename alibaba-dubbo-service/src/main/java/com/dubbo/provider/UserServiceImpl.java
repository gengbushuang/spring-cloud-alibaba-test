package com.dubbo.provider;

import com.dubbo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String getNameById(String uid) {

//        log.info("----receive request uid="+uid);

        return String.format("[%s]: hello,%s",serviceName,uid);
    }
}
