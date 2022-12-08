package com.kise.pos.product;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProduct extends JInternalFrame {

    JLabel lblProductCode, lblProductName, lblProductVendor, lblProductDescription, lblProductQty,
             lblBuyPrice, lblMSRP;
    JTextField txtProductCode, txtProductName, txtProductVendor, txtProductDescription, txtProductQty,
             txtBuyPrice, txtMSRP;

    JButton btnSave;

    Connection connection;

    Statement statement;

    public AddProduct(Connection connection) {
        super("Add Product", false, true, true, true );
        setBounds(230, 30, 900, 500);
        setFrameIcon(new ImageIcon("resources\\icons8_product.png"));

        this.connection = connection;

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Font font = new Font("Malgun Gothic", Font.PLAIN, 18);

        lblProductCode = new JLabel("Product Code");
        lblProductCode.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductCode, gridBagConstraints);



        txtProductCode = new JTextField();
        txtProductCode.setText(generateCode());
        txtProductCode.setEditable(false);
        txtProductCode.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductCode, gridBagConstraints);


        lblProductName = new JLabel("Product Name");
        lblProductName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductName, gridBagConstraints);

        txtProductName = new JTextField();
        txtProductName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductName, gridBagConstraints);



        lblProductVendor = new JLabel("Product Vendor");
        lblProductVendor.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductVendor, gridBagConstraints);

        txtProductVendor = new JTextField();
        txtProductVendor.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductVendor, gridBagConstraints);


        lblProductDescription = new JLabel("Product Description");
        lblProductDescription.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductDescription, gridBagConstraints);

        txtProductDescription = new JTextField();
        txtProductDescription.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductDescription, gridBagConstraints);

        lblProductQty= new JLabel("Quantity in Stock");
        lblProductQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblProductQty, gridBagConstraints);

        txtProductQty = new JTextField();
        txtProductQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtProductQty, gridBagConstraints);

        lblBuyPrice = new JLabel("Buy Price");
        lblBuyPrice.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblBuyPrice, gridBagConstraints);

        txtBuyPrice = new JTextField();
        txtBuyPrice.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtBuyPrice, gridBagConstraints);

        lblMSRP = new JLabel("MSRP");
        lblMSRP.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblMSRP, gridBagConstraints);

        txtMSRP = new JTextField();
        txtMSRP.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtMSRP, gridBagConstraints);

        btnSave = new JButton("Save");
        btnSave.setFont(font);
        btnSave.setBackground(Color.BLUE);
        btnSave.setForeground(Color.WHITE);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        btnSave.addActionListener(e -> {

            String pCode = txtProductCode.getText();
            String pName = txtProductName.getText();
            String pVendor = txtProductVendor.getText();
            String pDesc = txtProductDescription.getText();
            String pQty = txtProductQty.getText();
            String pBuyPrice = txtBuyPrice.getText();
            String pMSRP = txtMSRP.getText();



            if(e.getSource() == btnSave){
                try {

                    statement = this.connection.createStatement();

                    String insert = "insert into products (product_code, product_name, product_vendor," +
                            " product_description, quantity_in_stock, buy_price, MSRP)" +
                            " values('"+pCode+"', '"+pName+"', '"+pVendor+"', '"+pDesc+"', '"+pQty+"', '"+pBuyPrice+"', '"+pMSRP+"')";

                    int rowsAffected = statement.executeUpdate(insert);

                    JOptionPane.showMessageDialog(null, rowsAffected +  " Product Added Successfully.");

                    dispose();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
        add(btnSave, gridBagConstraints);

        setVisible(true);

    }

    public String generateCode(){

        String [] numbers = {"1","2","3","4","5","6","7","8","9"};

        StringBuilder generatedID = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = (int)  Math.floor(Math.random() * numbers.length );
            generatedID.append(numbers[index]);

        }
        return "PRD_" + generatedID;
    }
}
