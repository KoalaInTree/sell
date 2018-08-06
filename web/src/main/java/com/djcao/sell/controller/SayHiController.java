package com.djcao.sell.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.djcao.sell.exception.TestException;
import com.djcao.sell.service.TestExceptionHandlerService;
import com.djcao.sell.service.WebSocketService;
import com.djcao.sell.vo.WordsOfWelcomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@RestController
@RequestMapping("say")
public class SayHiController {

    @Autowired
    private TestExceptionHandlerService testExceptionHandlerService;

    @Autowired
    private WebSocketService webSocketService;

    @RequestMapping("hi")
    public WordsOfWelcomeVO sayHi() throws InterruptedException {
        WordsOfWelcomeVO vo = new WordsOfWelcomeVO();
        vo.setCode(1);
        vo.setWords("hi,i'm test");
        throw new NullPointerException("test");
    }

    @GetMapping("throw")
    public String throwException() throws TestException {
        testExceptionHandlerService.throwException();
        return "报错了";
    }

    @GetMapping("send-websocket")
    public void testWebSocket() throws IOException {
        webSocketService.sendMessageByBroadCast("hi,client,i'm server");
    }

    @GetMapping("go-to-websocket")
    public ModelAndView gotoWebsocket(ModelAndView modelAndView){
        modelAndView.setViewName("websocket");
        return modelAndView;
    }
}
