package com.example.akosoftcompany.servlets;

import com.example.akosoftcompany.service.UserService;
import com.example.akosoftcompany.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletRemoveUser", value = "/ServletRemoveUser")
public class ServletRemoveUser extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.removeUserById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/andersen_project/ServletGetAll");
    }
}
