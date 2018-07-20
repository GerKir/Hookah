package ru.gerkir;

import ru.gerkir.BaseWorker;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            if (BaseWorker.check(s1, s2)) {
                response.sendRedirect(request.getContextPath() + "/account.jsp");
            } else {
                response.addHeader("message", "Неверный аккаунт или пароль");
                request.getRequestDispatcher("/signin.jsp").forward(request, response);
            }
        }
        catch (ClassNotFoundException e) {
            //it means that bd not work
            response.sendRedirect(request.getContextPath() + "/index.html");

        }
    }
}
