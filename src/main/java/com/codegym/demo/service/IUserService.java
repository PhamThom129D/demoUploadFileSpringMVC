package com.codegym.demo.service;

import com.codegym.demo.model.User;

import java.util.List;

public interface IUserService {
    List<User> getListUser();
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    void save(User user);
}
