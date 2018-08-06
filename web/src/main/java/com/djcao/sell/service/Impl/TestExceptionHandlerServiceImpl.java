package com.djcao.sell.service.Impl;

import com.djcao.sell.exception.TestException;
import com.djcao.sell.service.TestExceptionHandlerService;
import org.springframework.stereotype.Service;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@Service
public class TestExceptionHandlerServiceImpl implements TestExceptionHandlerService{
    @Override
    public void throwException() throws TestException {
        throw new TestException("我是测试的");
    }
}
