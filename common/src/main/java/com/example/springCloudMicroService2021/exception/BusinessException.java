/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.springCloudMicroService2021.exception
 * @className com.example.springCloudMicroService2021.exception.BusinessException
 */
package com.example.springCloudMicroService2021.exception;

/**
 * BusinessException
 * @description BusinessException 业务异常
 * @author chenzhicheng
 * @date 2023/6/16 17:43
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
