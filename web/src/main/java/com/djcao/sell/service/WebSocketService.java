package com.djcao.sell.service;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@Component
@ServerEndpoint("/websocekt")
public class WebSocketService {

    private Session session;
    private static CopyOnWriteArraySet<WebSocketService> webSocketServices = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketServices.add(this);
        System.out.println("open");
    }

    @OnClose
    public void onClose(){
        webSocketServices.remove(this);
        System.out.println("close");
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("收到:".concat(message));
    }


    public void sendMessageByBroadCast(String message) throws IOException {
        for (WebSocketService webSocketService : webSocketServices){
            webSocketService.getSession().getBasicRemote().sendText(message);
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
