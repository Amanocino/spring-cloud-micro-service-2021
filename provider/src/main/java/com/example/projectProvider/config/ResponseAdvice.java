/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.projectProvider.config
 * @className com.example.projectProvider.config.ResponseAdvice
 */
package com.example.projectProvider.config;

import com.example.springCloudMicroService2021.pojo.Result.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * ResponseAdvice
 * @description ResponseAdvice 处理统一返回结果
 * @author chenzhicheng
 * @date 2023/6/16 16:06
 */
@RestControllerAdvice(basePackages = "com.example.projectProvider.controller")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    //supports：判断是否要交给 beforeBodyWrite 方法执行，ture：需要；false：不需要
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果不需要进行封装的，可以添加一些校验手段，比如添加标记排除的注解
        return true;
    }

    //beforeBodyWrite：对 response 进行具体的处理
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 提供一定的灵活度，如果body已经被包装了，就不进行包装
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
