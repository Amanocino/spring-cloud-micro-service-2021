/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.projectProvider
 * @className com.example.projectProvider.service.HelloServiceImpl
 */
package com.example.projectProvider.service;

import com.example.springCloudMicroService2021.pojo.User;
import com.example.springCloudMicroService2021.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 * @description HelloServiceImpl class
 * @author chenzhicheng
 * @date 2023/5/16 21:17
 */
@DubboService
public class HelloServiceImpl implements UserService {

    @Override
    public User sayHello() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        return user;
    }
}
