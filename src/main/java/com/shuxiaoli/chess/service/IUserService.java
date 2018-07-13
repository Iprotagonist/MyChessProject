package com.shuxiaoli.chess.service;

import com.shuxiaoli.chess.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findOne(String userName);
    void saveUser(User user);
    List<User> findAll();
    User findUserById(Integer id);
}
