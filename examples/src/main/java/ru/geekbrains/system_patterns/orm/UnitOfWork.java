package ru.geekbrains.system_patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final Connection conn;

    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();

    public UnitOfWork(Connection conn) {
        this.conn = conn;
    }

    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }

    public void commit()  {
        try {
            conn.setAutoCommit(false);
            insert();
            update();
            delete();
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void update() {
        if (this.updateUsers.size() == 0) return;
        try (PreparedStatement update = conn.prepareStatement("UPDATE users SET login = ?, password = ? WHERE id = ?")) {
            for (User user:
                    this.updateUsers) {
                update.setLong(3, user.getId());
                update.setString(1, user.getLogin());
                update.setString(2, user.getPassword());
                update.addBatch();
            }
            update.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() {
        if (this.newUsers.size() == 0) return;;
        try (PreparedStatement insert = conn.prepareStatement("INSERT INTO users (login, password) VALUES (?,?)")) {
            for (User user:
                 this.newUsers) {
                insert.setString(1, user.getLogin());
                insert.setString(2, user.getPassword());
                insert.addBatch();
            }
            insert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        if (deleteUsers.size() == 0) return;
        try (PreparedStatement delete = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            for (User user:
                    this.deleteUsers) {
                delete.setLong(1, user.getId());
                delete.addBatch();
            }
            delete.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
