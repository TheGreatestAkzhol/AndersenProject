package com.example.akosoftcompany.servlets;

import com.example.akosoftcompany.service.UserService;
import com.example.akosoftcompany.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddUser", value = "/ServletAddUser")
public class ServletAddUser extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/addUser");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        byte age = Byte.parseByte(request.getParameter("age"));
        userService.saveUser(name,lastname,age);
        response.sendRedirect("/ServletGetAll");
    }
}
