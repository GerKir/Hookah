package ru.gerkir;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.*;

public class BaseWorker {
    private static final String url = "jdbc:mysql://localhost:3306/hookah";
    private static final String user = "root";
    private static final String password = "322";

    public static boolean registrationSuccsess(String account_name, String account_password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into users (account, password) VALUES ('" + account_name + "','" + account_password + "');");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String account_name, String account_password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from users where account = '" + account_name + "' " +
                                                                                        "and password = '" + account_password + "';");
                resultSet.next();
                if (resultSet.getString("account").equals(account_name) &&
                        resultSet.getString("password").equals(account_password)) {
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setMail(resultSet.getString("mail"));
                    user.setRole(resultSet.getString("root"));
                    return user;
                } else return null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}