/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.springCloudMicroService2021.exception
 * @className com.example.springCloudMicroService2021.exception.ForbiddenException
 */
package com.example.springCloudMicroService2021.exception;

/**
 * ForbiddenException 自定义异常
 * @description ForbiddenException 权限访问异常
 * @author chenzhicheng
 * @date 2023/6/16 17:42
 */
public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message) {
        super(message);
    }
}
