package com.example.akosoftcompany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());
    private static final String HOST = "jdbc:postgresql://192.168.0.102:5432/newbase";
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "password";
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
            if(!connection.isClosed()){
                LOGGER.log(Level.INFO,"We've connected with database succesfully!)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO,"Unfortunately we've not connected");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
