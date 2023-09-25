package com.example.akosoftcompany.servlets;

import com.example.akosoftcompany.model.User;
import com.example.akosoftcompany.service.UserService;
import com.example.akosoftcompany.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletGetAll", value = "/ServletGetAll")
public class ServletGetAll extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users =  userService.getAllUsers();
        request.getSession().setAttribute("users",users);
        response.sendRedirect("/andersen_project/showAll");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
