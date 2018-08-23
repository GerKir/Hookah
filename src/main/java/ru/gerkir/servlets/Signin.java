package ru.gerkir.servlets;


import ru.gerkir.BaseWorker;
import ru.gerkir.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@WebServlet("/signin")
public class Signin extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String s1 = request.getParameter("login");
        String s2 = request.getParameter("password");
        response.addHeader("login", s1);
        if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) {
            response.addHeader("message", "Заполните все поля");
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
        }

        try {
            User user = BaseWorker.getUser(s1, s2);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/account");
        } catch (UserPrincipalNotFoundException e){
            response.addHeader("message", "Неверный аккаунт или пароль");
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
        }
    }
}
