package ru.geekbrains.system_patterns.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connect();
            UserRepository repository = new UserRepository(connection);
            repository.beginTransaction();
            repository.insert(new User(null, "test", "pass"));
            repository.insert(new User(null, "test1", "pass"));
            repository.insert(new User(null, "test2", "pass"));
            repository.update(new User(1L, "Test_edit", "pass"));
            repository.delete(new User(4L, null, null));
            repository.commitTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
