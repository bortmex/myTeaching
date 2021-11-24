package com.rog.teach.dao;

import com.rog.teach.model.User;

import java.util.List;

public interface UserDao {

    User getUserByUsername(String username) throws Exception;

    List<User> findAllUsers();
}
