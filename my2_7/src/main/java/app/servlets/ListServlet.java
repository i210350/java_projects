package app.servlets;


import app.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserService userService = UserService.getInstance();
//        List<String> names = userService.list();
//        req.setAttribute("userNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
