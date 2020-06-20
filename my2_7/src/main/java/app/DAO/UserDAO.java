package app.DAO;

import app.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static String url = "jdbc:mysql://localhost/preprojectdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "admin";
    private static String password = "111111";

//    private Session session;
//
//    public UserDAO(Session session) {
//        this.session = session;
//    }

    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);
                    User user = new User(id, name, age);
                    list.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }
//
//    public void saveUser(User user) {
//        Transaction transaction = session.beginTransaction();
//        session.save(user);
//        transaction.commit();
//        session.close();
//    }
//
//    public void deleteUser(User user) {
//        Transaction transaction = session.beginTransaction();
//        session.delete(user);
//        transaction.commit();
//        session.close();
//    }

//    public Car getCar(String brand, String model, String licensePlate) {
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("from Car where brand = :brand and model = :model and licensePlate = :licensePlate");
//        query.setParameter("brand", brand);
//        query.setParameter("model", model);
//        query.setParameter("licensePlate", licensePlate);
//        transaction.commit();
//        return (Car) query.list().get(0);
//    }

//    public void deleteCarDao(Long id) {
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("delete Car where id = :id");
//        query.setParameter("id", id) ;
//        query.executeUpdate();
//        transaction.commit();
//    }

//    public void deleteAllCarDao() {
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("delete Car");
//        query.executeUpdate();
//        transaction.commit();
//    }

    public int insert(String name, Integer age) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO users (name, age) Values (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, age);

                    return preparedStatement.executeUpdate();
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
