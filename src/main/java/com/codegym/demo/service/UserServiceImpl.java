package com.codegym.demo.service;

import com.codegym.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private static final Map<Integer, User> users ;
    static {
        users = new HashMap<>();
        users.put(1,new User(1,"Nguyễn Văn A","vykid9@gmail.com","Hà Nội"));
        users.put(2,new User(2,"Nguyễn Văn B","vykid9@gmail.com","Hà Nội"));
        users.put(3,new User(3,"Nguyễn Văn C","vykid9@gmail.com","Hà Nội"));
        users.put(4,new User(4,"Nguyễn Văn D","vykid9@gmail.com","Hà Nội"));
    }

    @Override
    public List<User> getListUser() {
        return new ArrayList<>( users.values());
    }

    @Override
    public User getUserById(int id) {
        User user = users.get(id);
        return user;
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void updateUser(User user) {
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
        }
    }
    @Override
    public void deleteUser(int id) {
        users.remove(id);
    }
}
