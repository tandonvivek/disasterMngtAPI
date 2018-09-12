package com.fis.service;

import java.util.List;

import com.fis.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}