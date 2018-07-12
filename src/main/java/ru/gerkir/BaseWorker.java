package ru.gerkir;

import java.sql.*;

public class BaseWorker {
    public static boolean check(String account_name, String account_password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/hookah";
        String user = "root";
        String password = "322";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users where account = '" + account_name + "';");
            resultSet.next();

            if (    resultSet.getString("account").equals(account_name) &&
                    resultSet.getString("password").equals(account_password)) {
                return true;
            } else return false;
        }
        catch (SQLException e){
            return false;
        }
    }
}
