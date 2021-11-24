package com.rog.teach.sevices;

import com.rog.teach.dao.UserDao;
import com.rog.teach.model.User;

public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User u = dao.getUserByUsername(user.getUsername());

        return u != null;
    }
}
