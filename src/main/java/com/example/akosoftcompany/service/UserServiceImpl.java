package com.example.akosoftcompany.service;


import com.example.akosoftcompany.dao.UserDao;
import com.example.akosoftcompany.dao.UserDaoJDBCImpl;
import com.example.akosoftcompany.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao udji = new UserDaoJDBCImpl();
    public void createUsersTable() {
        udji.createUsersTable();
    }

    public void dropUsersTable() {
        udji.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udji.saveUser(name,lastName,age);
    }

    @Override
    public void updateUser(long id, User user) {
        udji.updateUser(id,user);
    }

    public void removeUserById(long id) {
        udji.removeUserById(id);
    }

    @Override
    public User findOne(long id) {
        return udji.findOne(id);
    }

    public List<User> getAllUsers() {

        return udji.getAllUsers();
    }

    public void cleanUsersTable() {
        udji.cleanUsersTable();
    }
}
