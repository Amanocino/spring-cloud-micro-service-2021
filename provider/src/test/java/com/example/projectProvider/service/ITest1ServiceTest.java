package com.example.projectProvider.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.projectProvider.entity.Test1;
import com.example.projectProvider.mapper.Test1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ITest1ServiceTest {
    @Resource
    ITest1Service test1Service;
    @Resource
    Test1Mapper test1Mapper;

    @Test
    public void test(){
//        Test1 test1 = test1Service.getById("1");
//        Page<Test1> page = new Page<>(1, 10);
//        page.setOptimizeCountSql(true);
//        LambdaQueryWrapper<Test1> lambdaQueryWrapper = new LambdaQueryWrapper<>();
////        lambdaQueryWrapper.ge(Test1::getId, 1);
//        long start = System.currentTimeMillis();
//        Page<Test1> result = test1Mapper.selectPage(page, lambdaQueryWrapper);
//
//        long end = System.currentTimeMillis();
//        log.info("请求耗时：{}", end-start);
//        Page<Test1> result1 = test1Mapper.selectPage(page, lambdaQueryWrapper);
//
//      log.info("============================");
//      log.info("Start {}", test1.toString());
    }

}