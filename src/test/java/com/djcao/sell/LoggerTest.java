package com.djcao.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void testLog(){
        logger.debug("#####debug");
        logger.info("#######info");
        logger.warn("#######warn");
        logger.error("#######error");
    }
}
