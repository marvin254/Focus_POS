package com.kise.pos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class POS_UI extends JInternalFrame {
    JTextArea txtReceipt;
    JLabel lblProductCode, lblProductName, lblProductQty, lblProductPrice, lblTotal,
            lblPaid, lblBalance, lblChkOutTotal;
    JTextField txtCode, txtName, txtPrice, txtTotal,
            txtPaid, txtChkOutTotal, txtBalance;
    JComboBox<String> cbQty;
    JTable table;
    DefaultTableModel defaultTableModel;
    JButton btnFetch, btnAdd, btnPrint, btnCheckOut;
    JScrollPane scrollPane;
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JPanel panelAdd, panelChkOut;
    String[] quantities = {"1", "2", "3", "4", "5"};
    Connection connection;
    Statement statement;

    ResultSet resultSet;
    int qtyInStock, qty;

    Font font = new Font("Malgun Gothic", Font.PLAIN, 14);

    POS_UI(Connection connection) {
        super("POS", false, true, true, true);
        setBounds(34, 10, 1300, 650);
        setFrameIcon(new ImageIcon("images\\icons8_computer.png"));

        this.connection = connection;

        panelAdd = new JPanel();

        JPanel panel = new JPanel();
        panel.setLayout(gridBagLayout);

        lblProductCode = new JLabel("Product Code");
        lblProductCode.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lblProductCode, gridBagConstraints);


        txtCode = new JTextField();
        txtCode.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(txtCode, gridBagConstraints);

        btnFetch = new JButton("Fetch");
        btnFetch.setBackground(Color.BLUE);
        btnFetch.setForeground(Color.WHITE);
        btnFetch.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        btnFetch.addActionListener(e -> fetchData());
        panel.add(btnFetch, gridBagConstraints);


        lblProductName = new JLabel("Product Name");
        lblProductName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lblProductName, gridBagConstraints);

        txtName = new JTextField();
        txtName.setFont(font);
        txtName.setEditable(false);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(txtName, gridBagConstraints);

        lblProductQty = new JLabel("Product Quantity");
        lblProductQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lblProductQty, gridBagConstraints);


        cbQty = new JComboBox<>(quantities);
        cbQty.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        cbQty.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object obj = cbQty.getSelectedItem();
                String str = (String) obj;
                qty = 0;
                if (str != null) {
                    qty = Integer.parseInt(str);
                }

                double price = Double.parseDouble(txtPrice.getText());
                double totalAmount = qty * price;
                txtTotal.setText("" + totalAmount);
            }
        });
        panel.add(cbQty, gridBagConstraints);

        lblProductPrice = new JLabel("Price per Item");
        lblProductPrice.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lblProductPrice, gridBagConstraints);


        txtPrice = new JTextField();
        txtPrice.setFont(font);
        txtPrice.setEditable(false);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(txtPrice, gridBagConstraints);

        lblTotal = new JLabel("Total Amount");
        lblTotal.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lblTotal, gridBagConstraints);


        txtTotal = new JTextField();
        txtTotal.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(txtTotal, gridBagConstraints);

        btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 250;
        btnAdd.addActionListener(e -> addToTable());
        panel.add(btnAdd, gridBagConstraints);

        btnCheckOut = new JButton("Process ");
        btnCheckOut.setBackground(Color.YELLOW);
        btnCheckOut.setForeground(Color.WHITE);
        btnCheckOut.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        btnCheckOut.addActionListener(e -> {
            double totalAmount = getTotal();
            String strAmount = String.valueOf(totalAmount);
            txtChkOutTotal.setText(strAmount);

        });
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel.add(btnCheckOut, gridBagConstraints);

        panelAdd.add(panel, BorderLayout.WEST);


        JPanel panelT = new JPanel();

        JLabel saleID = new JLabel();
        saleID.setFont(font);
        panelT.add(saleID, BorderLayout.NORTH);

        defaultTableModel = new DefaultTableModel(0, 0);
        defaultTableModel.addColumn("Product Code");
        defaultTableModel.addColumn("Product Name");
        defaultTableModel.addColumn("Quantity");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Total");

        table = new JTable();
        table.setModel(defaultTableModel);
        scrollPane = new JScrollPane(table);

        panelT.add(scrollPane);

        add(panelAdd, BorderLayout.WEST);

        add(panelT, BorderLayout.CENTER);

        panelChkOut = new JPanel();
        panelChkOut.setLayout(gridBagLayout);

        lblChkOutTotal = new JLabel("Sale Total");
        lblChkOutTotal.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panelChkOut.add(lblChkOutTotal, gridBagConstraints);

        txtChkOutTotal = new JTextField();
        txtChkOutTotal.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panelChkOut.add(txtChkOutTotal, gridBagConstraints);

        lblPaid = new JLabel("Customer Pay");
        lblPaid.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panelChkOut.add(lblPaid, gridBagConstraints);


        txtPaid = new JTextField();
        txtPaid.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panelChkOut.add(txtPaid, gridBagConstraints);

        lblBalance = new JLabel("Balance");
        lblBalance.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panelChkOut.add(lblBalance, gridBagConstraints);


        txtBalance = new JTextField();
        txtBalance.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        panelChkOut.add(txtBalance, gridBagConstraints);

        btnCheckOut = new JButton("Checkout");
        btnCheckOut.setBackground(Color.YELLOW);
        btnCheckOut.setForeground(Color.WHITE);
        btnCheckOut.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        btnCheckOut.addActionListener(e -> getBalance());
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new Insets(10, 10, 20, 10);
        panelChkOut.add(btnCheckOut, gridBagConstraints);


        btnPrint = new JButton("Print Receipt", new ImageIcon("images\\icons8_print.png"));
        btnPrint.setBackground(Color.BLUE);
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        btnPrint.addActionListener(e -> {});
        panelChkOut.add(btnPrint, gridBagConstraints);

        add(panelChkOut, BorderLayout.EAST);
        setVisible(true);

    }

    public POS_UI() {
    }

    public void fetchData() {

        final String code = txtCode.getText().toUpperCase();
        try {
            statement = connection.createStatement();
            String query = "select * from products where product_code='" + code + "'";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                txtName.setText(resultSet.getString("product_name"));
                txtPrice.setText(resultSet.getString("MSRP"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            sum += Double.parseDouble((String) table.getValueAt(i, 4));
        }
        return sum;
    }

    public void getBalance() {
        double totalAmount = Double.parseDouble(txtChkOutTotal.getText());
        double customerPay = Double.parseDouble(txtPaid.getText());
        double balance = customerPay - totalAmount;

        String strBalance = String.valueOf(balance);

        txtBalance.setText(strBalance);

        JOptionPane.showMessageDialog(null, "Return a balance of " + balance);
    }

    public void addToTable() {
        defaultTableModel.addRow(new Object[]{txtCode.getText(), txtName.getText(), cbQty.getSelectedItem(),
                txtPrice.getText(), txtTotal.getText()});

        try {
            statement = connection.createStatement();
            String query = "select * from products";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String quantity = resultSet.getString("quantity_in_stock");
                qtyInStock = Integer.parseInt(quantity);
            }

            int newStockQty = qtyInStock - qty;
            String newQty = String.valueOf(newStockQty);
            String update = "update products set quantity_in_stock = '" + newQty + "' " +
                    "where product_code = '" + txtCode.getText().toUpperCase() + "'";
            statement.executeUpdate(update);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JTextArea populateReceipt() {

        txtReceipt = new JTextArea();
        txtReceipt.setSize(500, 400);
        txtReceipt.setFont(font);


        txtReceipt.setText(txtReceipt.getText() +
                "************************************************************ \n");
        txtReceipt.setText(txtReceipt.getText()
                + "**                 FOCUS POS RECEIPT                   ** \n");
        txtReceipt.setText(txtReceipt.getText() +
                "*********************************************************** \n");

        txtReceipt.setText(txtReceipt.getText() + " Name" + "\t" + "Qty" + "\t" + "Price" + "\t" + "Amount" + "\n");

        for (int i = 0; i < table.getRowCount(); i++) {
            String productName = (String) table.getValueAt(i, 1);
            String pQty = (String) table.getValueAt(i, 2);
            String productPrice = (String) table.getValueAt(i, 3);
            String productTotal = (String) table.getValueAt(i, 4);

            txtReceipt.setText(txtReceipt.getText() + productName + "\t" + pQty + "\t" + productPrice + "\t" + productTotal + "\n");
        }

        txtReceipt.setText(txtReceipt.getText() + "\n");
        txtReceipt.setText(txtReceipt.getText() + "\n");

        txtReceipt.setText(txtReceipt.getText() + "\t" + "\t" + "Total" + txtChkOutTotal.getText() + "\n");
        txtReceipt.setText(txtReceipt.getText() + "\t" + "\t" + "Amount paid" + txtPaid.getText() + "\n");
        txtReceipt.setText(txtReceipt.getText() + "\t" + "\t" + "Balance" + txtBalance.getText() + "\n");

        return txtReceipt;
    }

}
