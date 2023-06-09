package com.example.projectProvider.service.impl;

import com.example.projectProvider.entity.Test;
import com.example.projectProvider.mapper.TestMapper;
import com.example.projectProvider.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenzhicheng
 * @since 2023-05-19
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
