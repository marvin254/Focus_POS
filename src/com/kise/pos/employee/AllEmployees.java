package com.kise.pos.employee;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllEmployees extends JInternalFrame {

    JScrollPane scrollPane;
    JTable table;
    Connection connection;
    Statement statement;

    ResultSet resultSet;

    String[] columnHeaders = {"Employee ID", "Full Name", "Email", "Mobile", "Gender", "Job Title"};

    String[][] data;


    public AllEmployees(Connection connection) {
        super("All Employees", false, true, true, true);
        setBounds(84, 10, 1200, 550);
        setFrameIcon(new ImageIcon("images\\icons8_user.png"));

        this.connection = connection;

        try {
            statement = this.connection.createStatement();

            String fetch = "select * from employees";

            data = new String[getRowCount(fetch)][columnHeaders.length];

            resultSet = statement.executeQuery(fetch);

            int counter = 0;

            while (resultSet.next()) {
                data[counter][0] = resultSet.getString(1);
                data[counter][1] = resultSet.getString(2);
                data[counter][2] = resultSet.getString(3);
                data[counter][3] = resultSet.getString(4);
                data[counter][4] = resultSet.getString(5);
                data[counter][5] = resultSet.getString(6);

                counter++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table = new JTable(data, columnHeaders);
        scrollPane = new JScrollPane(table);

        add(scrollPane);

        setVisible(true);
    }

    public int getRowCount(String query) throws SQLException {

        statement = this.connection.createStatement();

        resultSet = statement.executeQuery(query);
        int count = 0;

        while (resultSet.next()) {
            count++;

        }
        return count;

    }

}

