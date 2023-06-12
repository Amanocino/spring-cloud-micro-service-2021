package com.example.projectProvider.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenzhicheng
 * @since 2023-05-19
 */
@Getter
@Setter
public class Test1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer num1;

    private String num2;

    private Integer type1;

    private Integer type2;

    private String str1;

    private String str2;
}
