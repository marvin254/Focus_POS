package com.kise.pos.product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllProducts extends JInternalFrame {

    JTable table;
    JScrollPane scrollPane;

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String[] columnHeaders = {"Product Code", "Product Name", "Product Vendor", "Product Description", "Quantity in Stock",
             "Buy Price", "MSRP"};

    String[][] productData;

    public AllProducts(Connection connection) {
        super("All Products", false, true, true, true);
        setBounds(84, 10, 1200, 600);
        setFrameIcon(new ImageIcon("images\\icons8_product.png"));

        this.connection = connection;

        try {
            statement = this.connection.createStatement();
            String query = "select * from products";

            productData = new String[getRowCount(query)][columnHeaders.length];

            resultSet = statement.executeQuery(query);

            int counter = 0;

            while (resultSet.next()) {

                productData[counter][0] = resultSet.getString(1);
                productData[counter][1] = resultSet.getString(2);
                productData[counter][2] = resultSet.getString(3);
                productData[counter][3] = resultSet.getString(4);
                productData[counter][4] = resultSet.getString(5);
                productData[counter][5] = resultSet.getString(6);
                productData[counter][6] = resultSet.getString(7);

                counter++;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table = new JTable(productData, columnHeaders);
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
