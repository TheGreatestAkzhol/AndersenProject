package com.example.akosoftcompany.servlets;

import com.example.akosoftcompany.model.User;
import com.example.akosoftcompany.service.UserService;
import com.example.akosoftcompany.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUpdateUser", value = "/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = userService.findOne(id);
        request.getSession().setAttribute("user",user);
        response.sendRedirect("/andersen_project/editUser");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        byte age = Byte.parseByte(request.getParameter("age"));
        User user = new User(name,lastname,age);
        long id = Long.parseLong(request.getParameter("id"));
        userService.updateUser(id,user);
        response.sendRedirect("/andersen_project/ServletGetAll");
    }
}
