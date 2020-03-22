package com.eternitywars.api.DAL.Contexts.Chat;

import com.eternitywars.api.ApiApplication;
import com.eternitywars.api.Interfaces.Chat.IChatContainerContext;
import com.eternitywars.api.Models.Cards;
import com.eternitywars.api.Models.Entities.Card;
import com.eternitywars.api.Models.Entities.Chat;
import com.eternitywars.api.Models.ChatCollection;
import com.eternitywars.api.Models.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;


public class ChatContainerHibernateContext implements IChatContainerContext {

    private static SessionFactory sessionFactory = ApiApplication.sessionFactory;

    private Session session;
    private Transaction transaction;

    @Override
    public ChatCollection GetChatsByUser(User user) {
        String hql = "SELECT * FROM chat_user WHERE " + user.getUserId();

        List<Chat> chats;
        ChatCollection chatCollection = new ChatCollection();

        try
        {
            session = sessionFactory.openSession();

            TypedQuery<Chat> typedQuery = session.createQuery(hql, Chat.class);

            chats = typedQuery.getResultList();
            chatCollection.setChats(chats);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return chatCollection;
    }

    @Override
    public Chat GetChatById(int chatId) {
        Chat chat;

        try
        {
            session = sessionFactory.openSession();
            chat = session.find(Chat.class, chatId);
        } catch (Exception ex)
        {
            return null;
        } finally
        {
            session.close();
        }

        return chat;
    }

    @Override
    public boolean DeleteChat(Chat chat) {


        try
        {
            session = sessionFactory.openSession();
            session.remove(chat);
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally
        {
            session.close();
        }

        return true;

    }

    @Override
    public Chat CreateChat(Chat chat) {
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(chat);
            transaction.commit();
        } catch (Exception ex)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }

            ex.printStackTrace();
        } finally
        {
            session.close();
        }

        return chat;
    }
}
