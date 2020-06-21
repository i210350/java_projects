package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static String url = "jdbc:mysql://localhost/preprojectdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "admin";
    private static String password = "111111";

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String query = "create table if not exists users (" +
                                                                    "id bigint primary key not null auto_increment, " +
                                                                    "name varchar(20), " +
                                                                    "lastName varchar(30), " +
                                                                    "age tinyint)";
                Statement statement = conn.createStatement();
                statement.executeQuery(query);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void dropUsersTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                statement.executeQuery("drop table if exists users ");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO users (name, lastName, age) Values (?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setInt(3, age);
                    preparedStatement.executeUpdate();
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void removeUserById(long id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "delete from users where id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setLong(1, id);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    list.add(new User(resultSet.getString(2), resultSet.getString(2), resultSet.getByte(4)));
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public void cleanUsersTable() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("DELETE FROM users");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
