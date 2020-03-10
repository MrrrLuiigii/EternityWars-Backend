package com.eternitywars.Logic.WebsocketServer.Setup;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    public void sendmessage(Session session, String message) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        JSONObject jsonObject = new JSONObject(message);
        Class ReflectionClass = Class.forName("com.eternitywars.Logic." + jsonObject.getString("Subject"));
        Method method = ReflectionClass.getMethod(jsonObject.getString("Action"), JSONObject.class);
        method.invoke(ReflectionClass.getDeclaredConstructor().newInstance(), jsonObject);
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
