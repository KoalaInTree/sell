package com.djcao.sell.service;

import com.djcao.sell.exception.TestException;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
public interface TestExceptionHandlerService {

    public void throwException() throws TestException;
}
