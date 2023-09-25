package com.example.akosoftcompany.dao;
import com.example.akosoftcompany.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();
    void dropUsersTable();
    void saveUser(String name, String lastname, byte age);
    void updateUser(long id,User user);
    void removeUserById(long id);
    List<User> getAllUsers();
    User findOne(long id);
    void cleanUsersTable();
}
