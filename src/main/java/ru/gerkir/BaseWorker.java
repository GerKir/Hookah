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

    public static User getUser(String account_name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users where account = '" + account_name + "';");
            resultSet.next();

            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setMail(resultSet.getString("mail"));
            user.setRoot(resultSet.getString("root").equals("1")?true:false);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static String getName(String account_name, String account_password) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try (Connection connection = DriverManager.getConnection(BaseWorker.url, user, password);
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("select * from users where account = '" + account_name + "';");
//            resultSet.next();
//            return resultSet.getString("name");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
