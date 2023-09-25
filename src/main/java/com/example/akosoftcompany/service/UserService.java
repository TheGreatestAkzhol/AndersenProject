package com.example.akosoftcompany.service;


import com.example.akosoftcompany.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);
    void updateUser(long id,User user);

    void removeUserById(long id);
    User findOne(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
