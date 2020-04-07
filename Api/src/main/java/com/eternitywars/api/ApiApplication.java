package com.eternitywars.api;

import com.eternitywars.api.Models.Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApiApplication.class, args);
    }

    public static SessionFactory sessionFactory = getSessionFactory();

//    public static SessionFactory sessionFactory = getSessionFactory("hibernate.cfg.xml");
//    public static SessionFactory testSessionFactory = getSessionFactory("hibernate_test.cfg.xml");

    private static SessionFactory getSessionFactory(/*String config*/)
    {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");
//        configuration.configure("hibernate_test.cfg.xml");

//        configuration.configure(config);

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Card.class);
        configuration.addAnnotatedClass(Deck.class);
        configuration.addAnnotatedClass(Relationship.class);
        configuration.addAnnotatedClass(Lobby.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(Relationship.class);
        configuration.addAnnotatedClass(Message.class);
        configuration.addAnnotatedClass(Chat.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
