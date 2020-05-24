package com.eternitywars.Models;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsFrontendUser;
import com.eternitywars.Models.Enums.AccountStatus;
import org.eclipse.jetty.websocket.api.Session;

import java.util.List;

public class User extends Account
{
    private int gold;
    private int packAmount;
    private FriendCollection friendCollection;
    private List<Deck> decks;
    private CardCollection cardCollection;


    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }


    public User(String email, int gold, int packAmount, FriendCollection friendCollection, List<Deck> decks, CardCollection cardCollection) {
        this.email = email;
        this.gold = gold;
        this.packAmount = packAmount;
        this.friendCollection = friendCollection;
        this.decks = decks;
        this.cardCollection = cardCollection;
    }

    public User(WsFrontendUser frontendUser)
    {
        this.email = frontendUser.getEmail();
        this.gold = frontendUser.getGold();
        this.userId = frontendUser.getId();
        this.packAmount = frontendUser.getPackAmount();
        this.accountStatus = frontendUser.getStatus();
        this.username = frontendUser.getUsername();
    }

    public User(int id, String username, AccountStatus accountStatus, String email, int gold, int packAmount, FriendCollection friendCollection, List<Deck> decks, CardCollection cardCollection) {
        super(id, username, accountStatus);
        this.email = email;
        this.gold = gold;
        this.packAmount = packAmount;
        this.friendCollection = friendCollection;
        this.decks = decks;
        this.cardCollection = cardCollection;
    }

    public User(int id, String username, AccountStatus accountStatus, Session session, String email, int gold, int packAmount, FriendCollection friendCollection, List<Deck> decks, CardCollection cardCollection) {
        super(id, username, accountStatus, session);
        this.email = email;
        this.gold = gold;
        this.packAmount = packAmount;
        this.friendCollection = friendCollection;
        this.decks = decks;
        this.cardCollection = cardCollection;
    }

    public User() {
        super();
    }

    public User(String username, String email)
    {
        this.username = username;
        this.email = email;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public int getPackAmount()
    {
        return packAmount;
    }

    public void setPackAmount(int packAmount)
    {
        this.packAmount = packAmount;
    }

    public FriendCollection getFriendCollection()
    {
        return friendCollection;
    }

    public void setFriendCollection(FriendCollection friendCollection)
    {
        this.friendCollection = friendCollection;
    }

    public List<Deck> getDecks()
    {
        return decks;
    }

    public void setDecks(List<Deck> decks)
    {
        this.decks = decks;
    }

    public CardCollection getCardCollection()
    {
        return cardCollection;
    }

    public void setCardCollection(CardCollection cardCollection)
    {
        this.cardCollection = cardCollection;
    }
}
