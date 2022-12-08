package com.kise.pos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private String dbUser;
    private String dbPassword;
    Connection connection;

    public ConnectionPool() {
    }

    public ConnectionPool(String dbUser, String dbPassword) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }


    public Connection createDatabaseConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/pos";

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public boolean createDatabaseConnection_2() {
        String dbURl = "jdbc:mysql://localhost:3306/pos";
        boolean isConnected;

        try {
            connection = DriverManager.getConnection(dbURl, dbUser, dbPassword);
            isConnected = true;

        } catch (SQLException e) {
            isConnected = false;

            if (e.getErrorCode() == 1045) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } else if (e.getErrorCode() == 1044) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
//            throw new RuntimeException(e);
        }
        return isConnected;

    }
}
