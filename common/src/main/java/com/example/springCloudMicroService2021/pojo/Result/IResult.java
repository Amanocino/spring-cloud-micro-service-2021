/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.springCloudMicroService2021.pojo.Result
 * @className com.example.springCloudMicroService2021.pojo.Result.IResult
 */
package com.example.springCloudMicroService2021.pojo.Result;

/**
 * IResult
 * @description IResult interface
 * @author chenzhicheng
 * @date 2023/6/16 15:48
 */
//定义返回数据结构
public interface IResult {
    Integer getCode();
    String getMessage();
}