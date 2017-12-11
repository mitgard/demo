package ru.rustam.demo.service;

import ru.rustam.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findUserByUsername(String username);

    void saveUser(User user);


}
