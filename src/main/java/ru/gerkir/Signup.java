package ru.gerkir;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Signup extends HttpServlet {

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

        try {
            BaseWorker.register(s1, s2);
            response.sendRedirect(request.getContextPath() + "/account.jsp");

        } catch (ClassNotFoundException e) {
            //it means that bd not work
            response.sendRedirect(request.getContextPath() + "/index.html");

        } catch (SQLException e) {
            response.sendRedirect(request.getContextPath() + "/list.html");
        }
    }
}
