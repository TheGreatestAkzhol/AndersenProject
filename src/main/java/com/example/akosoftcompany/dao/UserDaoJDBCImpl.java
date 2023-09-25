package com.example.akosoftcompany.dao;



import com.example.akosoftcompany.model.User;
import com.example.akosoftcompany.util.Util;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoJDBCImpl implements UserDao {
    private final Logger LOGGER = Logger.getLogger(UserDaoJDBCImpl.class.getName());
    private PreparedStatement preparedStatement;
    private final String insertNew = "INSERT INTO newbase.public.user_base(name,lastname,age) VALUES(?,?,?)";
    private final String update = "UPDATE newbase.public.user_base SET name = ?, lastname = ?, age = ? where id = ?";
    public UserDaoJDBCImpl() {
    }
    public void createUsersTable() {
        String creating = "CREATE TABLE IF NOT EXISTS newbase.public.user_base" +
                "(ID serial primary key ," +
                "name VARCHAR(45) not null," +
                "lastname VARCHAR(45) not null," +
                "age int check(age>0))";
        String checking = "SELECT EXISTS "+
                "(SELECT FROM"+
                " pg_tables"+
                " where"+
                " schemaname = 'public' AND" +
                " tablename = 'userbase')";
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(8);
            Statement statement = connection.createStatement();
            statement.execute(creating);
            if(statement.execute(checking)){
                LOGGER.log(Level.INFO,"Base is already exist)");
            }else {
                LOGGER.log(Level.INFO, "You've created table");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql =  "DROP TABLE IF EXISTS newbase.public.user_base";
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(8);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            LOGGER.log(Level.INFO, "Table deleted in given database...");
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(8);
            preparedStatement = connection.prepareStatement(insertNew);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.execute();
            preparedStatement.close();
            LOGGER.log(Level.INFO,"User named {0} {1} is added to your database",new Object[]{name,lastName});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(long id, User newUser) {
        try{
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(8);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1,newUser.getName());
            ps.setString(2,newUser.getLastName());
            ps.setByte(3,newUser.getAge());
            ps.setLong(4,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String deleting = "delete from newbase.public.user_base where id = {0}";
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(2);
            Statement statement = connection.createStatement();
            statement.execute(MessageFormat.format(deleting,id));
            statement.close();
            LOGGER.log(Level.INFO,"User with id {0} is deleted from database",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String getAll = "Select * from newbase.public.user_base";
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(2);
            PreparedStatement ps = connection.prepareStatement(getAll);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId((long) resultSet.getInt("ID"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
            ps.close();
                return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(long id) {
        User user = new User();
        String query = "SELECT * FROM newbase.public.user_base where id = " + id;
        try{
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(2);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                user.setId((long) resultSet.getInt("ID"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void cleanUsersTable() {
        try {
            Connection connection = Util.getConnection();
            connection.setTransactionIsolation(8);
            String deleteUsers = "truncate table newbase.public.user_base";
            Statement statement = connection.createStatement();
            statement.execute(deleteUsers);
            LOGGER.log(Level.INFO,"All users deleted from your database");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
