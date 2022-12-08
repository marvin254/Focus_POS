package com.kise.pos.employee;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee extends JInternalFrame {
    JLabel lblEmployeeID, lblEmployeeName, lblEmployeeEmail, lblEmployeePhone, lblEmployeeGender, lblEmployeeJobTitle;

    JTextField txtSearch, txtEmployeeID, txtEmployeeName, txtEmployeeEmail, txtEmployeePhone, txtEmployeeGender,
            txtEmployeeJobTitle;
    JButton btnSearch, btnDelete;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    public DeleteEmployee(Connection connection) {
        super("Update Employee", false, true, true, true);
        setBounds(400, 30, 650, 550);
        setFrameIcon(new ImageIcon("images\\icons8_user.png"));

        this.connection = connection;

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Font font = new Font("Malgun Gothic", Font.PLAIN, 18);


        txtSearch = new JTextField();
        txtSearch.setToolTipText("Search for Employee");
        txtSearch.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtSearch, gridBagConstraints);


        btnSearch = new JButton("Search For Employee");
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

                String idValue = txtSearch.getText().toUpperCase();

                try {
                    statement = this.connection.createStatement();

                    String search = "select * from employees where employee_id = '" + idValue + "'";

                    resultSet = statement.executeQuery(search);

                    while (resultSet.next()) {

                        txtEmployeeID.setText(resultSet.getString(1));
                        txtEmployeeName.setText(resultSet.getString(2));
                        txtEmployeeEmail.setText(resultSet.getString(3));
                        txtEmployeePhone.setText(resultSet.getString(4));
                        txtEmployeeGender.setText(resultSet.getString(5));
                        txtEmployeeJobTitle.setText(resultSet.getString(6));
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        lblEmployeeID = new JLabel("Employee ID");
        lblEmployeeID.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeID, gridBagConstraints);


        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(font);
        txtEmployeeID.setEditable(false);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeID, gridBagConstraints);


        lblEmployeeName = new JLabel("Full Name");
        lblEmployeeName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeName, gridBagConstraints);

        txtEmployeeName = new JTextField();
        txtEmployeeName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeName, gridBagConstraints);


        lblEmployeeEmail = new JLabel("Email");
        lblEmployeeEmail.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeEmail, gridBagConstraints);

        txtEmployeeEmail = new JTextField();
        txtEmployeeEmail.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeEmail, gridBagConstraints);


        lblEmployeePhone = new JLabel("Mobile Number");
        lblEmployeePhone.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeePhone, gridBagConstraints);

        txtEmployeePhone = new JTextField();
        txtEmployeePhone.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeePhone, gridBagConstraints);

        lblEmployeeGender = new JLabel("Gender");
        lblEmployeeGender.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeGender, gridBagConstraints);

        txtEmployeeGender = new JTextField();
        txtEmployeeGender.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeGender, gridBagConstraints);

        lblEmployeeJobTitle = new JLabel("Job Title");
        lblEmployeeJobTitle.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeJobTitle, gridBagConstraints);

        txtEmployeeJobTitle = new JTextField();
        txtEmployeeJobTitle.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeJobTitle, gridBagConstraints);


        btnDelete = new JButton("Delete");
        btnDelete.setFont(font);
        btnDelete.setBackground(Color.BLUE);
        btnDelete.setForeground(Color.WHITE);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        btnDelete.addActionListener(e -> {
            if (e.getSource() == btnDelete) {

                String Id = txtSearch.getText().toUpperCase();

                String delete = " delete from employees where employee_id = '" + Id + "' ";

                try {

                    int rowsAffected = statement.executeUpdate(delete);

                    JOptionPane.showMessageDialog(null , rowsAffected + " Record deleted successfully");

                    dispose();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(btnDelete, gridBagConstraints);
        setVisible(true);
    }
}
