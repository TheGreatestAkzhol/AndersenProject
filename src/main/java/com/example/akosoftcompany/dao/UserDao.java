package com.example.akosoftcompany.dao;
import com.example.akosoftcompany.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();
    void dropUsersTable();
    void saveUser(String name, String lastname, byte age);
    void removeUserById(long id);
    List<User> getAllUsers();
    void cleanUsersTable();
}
