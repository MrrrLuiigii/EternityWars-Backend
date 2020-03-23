package com.eternitywars.Logic.WebsocketServer.Setup;

import com.eternitywars.Logic.WebsocketServer.Models.WsReturnMessage;
import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Service("WebsocketService")
public class WebsocketService {
    private Set<Session> listenerSessions = new CopyOnWriteArraySet<>();

    public void removeSession(Session session){
        listenerSessions.remove(session);
    }

    public void addSession(Session session){
        listenerSessions.add(session);
    }

    public void sendmessage(Session session, String message) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        JSONObject jsonObject = new JSONObject(message);
        Class ReflectionClass = Class.forName("com.eternitywars.Logic." + jsonObject.getString("Subject"));
        Method method = ReflectionClass.getMethod(jsonObject.getString("Action"), JSONObject.class);
        Object object = method.invoke(ReflectionClass.getDeclaredConstructor().newInstance(), jsonObject);
        WsReturnMessage wsReturnMessage = new WsReturnMessage(object, jsonObject.getString("Action"));
        Gson g = new Gson();
        session.getRemote().sendString(g.toJson(wsReturnMessage));
    }

    @PostConstruct
    private void init(){
        Runnable runnable = () -> {
            while (true){

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
