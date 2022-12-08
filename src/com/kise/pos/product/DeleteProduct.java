package com.kise.pos.product;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProduct extends JInternalFrame {
    JLabel lblProductCode, lblProductName, lblProductVendor, lblProductDescription, lblProductQty,
        lblBuyPrice, lblMSRP;
    JTextField txtSearch, txtProductCode, txtProductName, txtProductVendor, txtProductDescription, txtProductQty,
            txtBuyPrice, txtMSRP;

    JButton btnDelete, btnSearch;

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DeleteProduct(Connection connection) {
        super("Delete Product", false, true, true, true);
        setBounds(230, 30, 900, 550);
        setFrameIcon(new ImageIcon("images\\icons8_product.png"));

        this.connection = connection;

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Font font = new Font("Malgun Gothic", Font.PLAIN, 18);


        txtSearch = new JTextField();
        txtSearch.setToolTipText("Search for Product");
        txtSearch.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtSearch, gridBagConstraints);


        btnSearch = new JButton("Search For Product");
        btnSearch.setFont(font);
        btnSearch.setBackground(Color.BLUE);
        btnSearch.setForeground(Color.WHITE);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(btnSearch, gridBagConstraints);

        btnSearch.addActionListener(e -> {

            if (e.getSource() == btnSearch) {

                String productCode = txtSearch.getText().toUpperCase();

                try {
                    statement = this.connection.createStatement();

                    String search = "select * from products where product_code = '" + productCode + "'";

                    resultSet = statement.executeQuery(search);

                    while (resultSet.next()) {

                        txtProductCode.setText(resultSet.getString(1));
                        txtProductName.setText(resultSet.getString(2));
                        txtProductVendor.setText(resultSet.getString(3));
                        txtProductDescription.setText(resultSet.getString(4));
                        txtProductQty.setText(resultSet.getString(5));
                        txtBuyPrice.setText(resultSet.getString(6));
                        txtMSRP.setText(resultSet.getString(7));
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        lblProductCode = new JLabel("Product Code");
        lblProductCode.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductCode, gridBagConstraints);


        txtProductCode = new JTextField();
        txtProductCode.setFont(font);
        txtProductCode.setEditable(false);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductCode, gridBagConstraints);


        lblProductName = new JLabel("Product Name");
        lblProductName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductName, gridBagConstraints);

        txtProductName = new JTextField();
        txtProductName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductName, gridBagConstraints);


        lblProductVendor = new JLabel("Product Vendor");
        lblProductVendor.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductVendor, gridBagConstraints);

        txtProductVendor = new JTextField();
        txtProductVendor.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductVendor, gridBagConstraints);


        lblProductDescription = new JLabel("Product Description");
        lblProductDescription.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductDescription, gridBagConstraints);

        txtProductDescription = new JTextField();
        txtProductDescription.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductDescription, gridBagConstraints);

        lblProductQty = new JLabel("Quantity in Stock");
        lblProductQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductQty, gridBagConstraints);

        txtProductQty = new JTextField();
        txtProductQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductQty, gridBagConstraints);

        lblBuyPrice = new JLabel("Buy Price");
        lblBuyPrice.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblBuyPrice, gridBagConstraints);

        txtBuyPrice = new JTextField();
        txtBuyPrice.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtBuyPrice, gridBagConstraints);

        lblMSRP = new JLabel("MSRP");
        lblMSRP.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblMSRP, gridBagConstraints);

        txtMSRP = new JTextField();
        txtMSRP.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtMSRP, gridBagConstraints);


        btnDelete = new JButton("Delete");
        btnDelete.setFont(font);
        btnDelete.setBackground(Color.BLUE);
        btnDelete.setForeground(Color.WHITE);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        btnDelete.addActionListener(e -> {

            if (e.getSource() == btnDelete) {

                String productCode = txtSearch.getText().toUpperCase();

                String delete = "delete from products where product_code = '" + productCode + "'";

                try {
                    int rowsAffected = statement.executeUpdate(delete);

                    JOptionPane.showMessageDialog(null, rowsAffected + " Record Deleted successfully");

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });

        add(btnDelete, gridBagConstraints);

        setVisible(true);
    }
}
