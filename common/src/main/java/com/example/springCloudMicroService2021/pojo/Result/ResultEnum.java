/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.springCloudMicroService2021.pojo.Result
 * @className com.example.springCloudMicroService2021.pojo.Result.ResultEnum
 */
package com.example.springCloudMicroService2021.pojo.Result;

/**
 * ResultEnum
 * @description ResultEnum class
 * @author chenzhicheng
 * @date 2023/6/16 15:49
 */
public enum ResultEnum implements IResult{
    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}