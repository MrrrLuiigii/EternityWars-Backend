package com.eternitywars.api.DAL.Contexts.User;

import com.eternitywars.api.Interfaces.User.IUserContext;
import com.eternitywars.api.Models.User;

public class UserHibernateContext implements IUserContext {
    @Override
    public boolean UpdateUsername(User user) {
        return false;
    }

    @Override
    public boolean UpdateAccountStatus(User user) {
        return false;
    }

    @Override
    public boolean UpdatePackAmount(User user) {
        return false;
    }

    @Override
    public boolean UpdateGold(User user) {
        return false;
    }
}
