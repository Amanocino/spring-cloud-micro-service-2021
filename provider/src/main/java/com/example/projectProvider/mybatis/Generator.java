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
    private static final String PACKAGE_NAME = "com.example.industryappinternet";
    private static final String MODULE_NAME = "demo";

    // 表名,多个表使用英文逗号分割
    private static final String[] TBL_NAMES = { "test, test1" };

    // 表名的前缀,从表生成代码时会去掉前缀
    private static final String TABLE_PREFIX = "tbl_";



    public static void main(String[] args) {

        //获取当前工程路径  这里无需修改
        String projectPath = System.getProperty("user.dir");


        /**
         // 1.数据库配置(设置数据源)
         // 配置数据库连接以及需要使用的字段
         */
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(JDBC_URL, JDBC_USER_NAME,
                JDBC_PASSWORD)
                .dbQuery(new MySqlQuery())
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());


        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(dataSourceConfigBuilder);

        /**
         // 2.全局配置
         // 覆盖已生成文件
         // 不打开生成文件目录
         // 指定输出目录,注意斜杠的表示
         // 设置注释的作者
         // 设置注释的日期格式
         // 使用java8新的时间类型
         // swagger文档   enableSwagger()
         */
        fastAutoGenerator.globalConfig(
                globalConfigBuilder -> globalConfigBuilder
                        .fileOverride()
                        .disableOpenDir()

                        .outputDir(projectPath + "/src/main/java1")
                        .author("songtiancheng")

                        .outputDir(projectPath + "/src/main/java1")
                        .author("chenzhicheng")

                        .commentDate("yyyy-MM-dd HH:mm:ss")
                        .dateType(DateType.TIME_PACK)
        );
        /**
         日期类型 DateType
         DateType.ONLY_DATE 使用 java.util.date包下的 Date
         DateType.SQL_PACK 使用 java.sql包下的 Date
         DateType.TIME_PACK   因为会使用 java.time.LocalDateTime jdk1.8以上才支持  (推荐使用)
         */


        /**
         // 3.包配置
         // 设置父包名
         // 设置父包模块名
         // 设置MVC下各个模块的包名
         // 设置XML资源文件的目录
         */
        fastAutoGenerator.packageConfig(
                packageConfigBuilder -> packageConfigBuilder
                        .parent(PACKAGE_NAME)
//                        .moduleName(MODULE_NAME)
                        .entity("domain")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
        );

        /**
         // 4.模板配置
         // 默认的是Velocity引擎模板,这里我们就不需要操作了
         */


        /**
         // 5.注入配置 TODO
         */


        /**
         // 6.策略配置
         // 设置需要生成的表名
         // 设置过滤表前缀
         */
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .enableCapitalMode()
                        .enableSkipView()
                        .disableSqlFilter()
                        .addInclude(TBL_NAMES)
//                        .addTablePrefix(TABLE_PREFIX)
        );


        /**
         // 6.1 Entity策略配置
         // 生成实体时生成字段的注解，包括@TableId注解等---
         // 数据库表和字段映射到实体的命名策略，为下划线转驼峰
         // 全局主键类型为ASSIGN_ID    雪花算法
         // 实体名称格式化为XXXEntity   formatFileName("%sEntity")
         // 支持lombok开启注解
         // 逻辑删除字段名
         // 自动填充配置  create_time  update_time 两种方式
         // 开启乐观锁
         // 禁用生成 serialVersionUID，默认值:true
         */
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder ->
                        strategyConfigBuilder.entityBuilder()

                                .enableTableFieldAnnotation()
                                .naming(NamingStrategy.underline_to_camel)
                                .columnNaming(NamingStrategy.underline_to_camel)
                                .idType(IdType.AUTO)
                                .enableLombok()
                                .logicDeleteColumnName("deleted")
                                .logicDeletePropertyName("deleted")
                                .addTableFills(new Column("create_time", FieldFill.INSERT))
                                .addTableFills(new Property("updateTime",FieldFill.INSERT_UPDATE))
                                .versionColumnName("version")
                                .disableSerialVersionUID()
        );

        /**
         // 6.2 Controller策略配置
         // 开启生成@RestController控制器
         // 开启请求风格  localhost:8080/hello_id_2
         */
        fastAutoGenerator
                .strategyConfig(strategyConfigBuilder ->
                        strategyConfigBuilder
                                .controllerBuilder()
                                .enableRestStyle()
                                .enableHyphenStyle()
                );

        /**
         // 6.3.Service策略配置
         // 格式化service接口和实现类的文件名称，去掉默认的ServiceName前面的I ----
         */
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl"));

        /**
         // 6.4.Mapper策略配置
         // 格式化 mapper文件名,格式化xml实现类文件名称
         */
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder ->
                        strategyConfigBuilder.mapperBuilder()
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper"));

        /** 7.生成代码
         *
         */
        fastAutoGenerator.execute();

    }

}
