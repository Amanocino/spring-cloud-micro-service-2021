/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.gateway.controller
 * @className com.example.gateway.controller.UserController
 */
package com.example.gateway.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson2.JSON;
import com.example.gateway.handler.UserBlockHandler;
import com.example.springCloudMicroService2021.pojo.User;
import com.example.springCloudMicroService2021.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * @description UserController class
 * @author chenzhicheng
 * @date 2023/5/17 13:41
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @DubboReference
    private UserService userService;

//    @SentinelResource(value = "userInfo")
    @PostMapping("/userInfo")
    public User userInfo(){
        return userService.sayHello();
    }
    /**
     * 测试流控规则
     */
    @PostMapping("/testFlow")
    @SentinelResource(value = "user-testFlow",
            blockHandlerClass = UserBlockHandler.class, //对应异常类
            blockHandler = "handleException",  //只负责sentinel控制台配置违规
            fallback = "handleError",   //只负责业务异常
            fallbackClass = UserBlockHandler.class)
    public String testFlow() {
        User user = userService.sayHello();
        return JSON.toJSONString(user);
    }

    /**
     * 测试降级规则
     */
    @PostMapping("/testDegrade")
    @SentinelResource(value = "user-testDegrade",
            blockHandlerClass = UserBlockHandler.class, //对应异常类
            blockHandler = "handleException",  //只负责sentinel控制台配置违规
            fallback = "handleError",   //只负责业务异常
            fallbackClass = UserBlockHandler.class)
    public String testDegrade() {
        User user = userService.sayHello();
        return JSON.toJSONString(user);
    }
}
