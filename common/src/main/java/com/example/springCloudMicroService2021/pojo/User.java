/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.springCloudMicroService2021.pojo
 * @className com.example.springCloudMicroService2021.pojo.User
 */
package com.example.springCloudMicroService2021.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * User
 * @description User test class
 * @author chenzhicheng
 * @date 2023/5/17 11:47
 */
@Data
public class User implements Serializable {
    private String username;
    private String password;
}
