package ru.gerkir.servlets;

import ru.gerkir.BaseWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class Signup extends HttpServlet {

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
        // TODO: 21.07.18 добавить верификацию
        response.addHeader("login", s1);
        if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) {
            response.addHeader("message", "Заполните все поля");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
        else if (BaseWorker.registrationSuccsess(s1, s2)){
            // TODO: 21.07.18 добавить сообщение, что регистрация прошла успешно
            response.sendRedirect(request.getContextPath() + "/account.jsp");

//            response.addHeader("loggin", s1);
//            response.addHeader("message", "Регистрация прошла успешно!");
//            request.getRequestDispatcher("/signin.jsp").forward(request, response);
        }
        else {
            response.addHeader("message", "Такой пользователь уже существует");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }

    }
}
