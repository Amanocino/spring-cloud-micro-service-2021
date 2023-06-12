/**
 * @projectName banma_usermanager
 * @package org.firstarr.banmaUsermanager.mybatis
 * @className org.firstarr.banmaUsermanager.mybatis.Generator
 */
package com.example.projectProvider.mybatis;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Generator
 * @description autogenerate mybatis code
 * @author chenzhicheng
 * @date 2022/6/22 11:04
 */
public class Generator {
    // 数据库连接字段配置
    private static final String JDBC_URL = "jdbc:mysql://172.16.0.35:3310/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSl=true";
    private static final String JDBC_USER_NAME = "root";
    private static final String JDBC_PASSWORD = "123456";

    // 包名和模块名
    private static final String PACKAGE_NAME = "com.example.projectProvider";
    private static final String MODULE_NAME = "demo";

    // 表名,多个表使用英文逗号分割
    private static final String[] TBL_NAMES = { "test, test1" };

    // 表名的前缀,从表生成代码时会去掉前缀
    private static final String TABLE_PREFIX = "tbl_";



    public static void main(String[] args) {
        FastAutoGenerator.create(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)
            // 全局配置
            .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).outputDir("F:\\work\\java\\spring-cloud-micro-service-2021\\spring-cloud-micro-service-2021\\provider\\src\\main\\java1").fileOverride())
            // 包配置
            .packageConfig((scanner, builder) -> builder.parent(PACKAGE_NAME))
            // 策略配置
            .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                    .controllerBuilder().enableRestStyle().enableHyphenStyle()
                    .entityBuilder().enableLombok().addTableFills(
                            new Column("create_time", FieldFill.INSERT)
                    ).build())
            /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
             */
            .execute();



    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
