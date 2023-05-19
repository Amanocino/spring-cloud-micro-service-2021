/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.project.consumer.Controller
 * @className com.project.consumer.Controller.HelloController
 */
package com.project.consumer.Controller;

import com.example.springCloudMicroService2021.pojo.User;
import com.example.springCloudMicroService2021.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * @description HelloController class
 * @author chenzhicheng
 * @date 2023/5/16 21:22
 */
@RestController
@RequestMapping(value = "/test")
public class HelloController {
    @DubboReference
    private UserService userService;

    @PostMapping("/userInfo")
    public User userInfo(){
        return userService.sayHello();
    }
}
