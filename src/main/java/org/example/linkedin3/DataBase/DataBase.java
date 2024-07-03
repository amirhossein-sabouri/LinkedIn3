package org.example.linkedin3.DataBase;

import org.example.linkedin3.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    String url = "jdbc:mysql://localhost:3306/?user=root";
    private DataBase(){

    }
    public static void makeConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LinkedIn","root","1234");
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection() throws SQLException {
        if(connection != null){
            statement.close();
            connection.close();
        }
    }
    public static int  createUser(User user) throws SQLException {
        makeConnection();
//        statement.execute(String.format("INSERT INTO users(username,name,lastname,email,password) values"+ "'%s','%s','%s','%s','%s'",
//                user.getUsername(),user.getName(),user.getLastname(),user.getEmail(),user.getPassword()),  Statement.RETURN_GENERATED_KEYS);
//
//        ResultSet re = statement.getGeneratedKeys();
//        re.next();
//        int id = re.getInt(1);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users(username, name, lastname, email, password) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getName());
        statement.setString(3, user.getLastname());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt(1);

        closeConnection();
        return id;
    }


    public static void deleteUser(User user) throws SQLException {
        makeConnection();
        statement.execute(String.format("DELETE FROM users WHERE id = %d",user.getId()));
        closeConnection();
    }
    public static ArrayList<User> getAllUsers() throws SQLException {
        makeConnection();
        ResultSet re = statement.executeQuery("SELECT * FROM users");
        ArrayList<User> users = new ArrayList<>();
     while(re.next()){
         users.add(new User(re.getInt("id"),re.getString("name"),re.getString("lastname")
                 ,re.getString("email"),re.getString("password")
                 ,re.getString("username")));

     }
     closeConnection();
        return users;
    }
    public static void updateUser(User user) throws SQLException {
        makeConnection();
        statement.execute(String.format("UPDATE users SET name = '%s',lastname = '%s',"
        +"email = '%s',password = '%s',username = '%s',additionalName = '%s',headlines = '%s',city = '%s',country = '%s'" +
                        ", WHERE id = %d",user.getName(),
                user.getLastname(),user.getEmail(),user.getPassword(),user.getUsername(),user.getId()));
        closeConnection();
    }

}

//package com.sinarmin.server.dataAccess;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
