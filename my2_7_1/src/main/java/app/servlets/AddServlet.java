package app.servlets;

import app.entities.User;
import app.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req, resp);

//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//        try{
//            String url = "jdbc:mysql://localhost/preprojectdb?serverTimezone=Europe/Moscow&useSSL=false";
//            String username = "admin";
//            String password = "111111";
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//
//                writer.println("Connection to ProductDB succesfull!");
//            }
//        }
//        catch(Exception ex){
//            writer.println("Connection failed...");
//            writer.println(ex);
//        }
//        finally {
//            writer.close();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        User user = new User(null, name, age);
        UserService userService = UserService.getInstance();
        userService.add(user);
    }
}
