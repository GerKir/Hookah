package ru.gerkir;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String s1 = request.getParameter("login");
        String s2 = request.getParameter("password");
        if (s1.equals("admin") && s2.equals("322")) {
            response.sendRedirect(request.getContextPath() + "/account.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/signup.jsp");

        }
    }
}
