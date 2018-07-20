package ru.gerkir;

import java.sql.*;

public class BaseWorker {
    private static final String url = "jdbc:mysql://localhost:3306/hookah";
    private static final String user = "root";
    private static final String password = "322";

    public static boolean check(String account_name, String account_password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users where account = '" + account_name + "';");
            resultSet.next();

            if (resultSet.getString("account").equals(account_name) &&
                    resultSet.getString("password").equals(account_password)) {
                return true;
            } else return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void register(String account_name, String account_password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into users (account, password) VALUES ('" + account_name + "','" + account_password + "');");
        }
    }
}
