package com.kise.pos.employee;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployee extends JInternalFrame {

    JLabel lblEmployeeID, lblEmployeeName, lblEmployeeEmail, lblEmployeePhone, lblEmployeeGender,
            lblEmployeeJobTitle;
    JTextField txtEmployeeID, txtEmployeeName, txtEmployeeEmail, txtEmployeePhone, txtEmployeeGender,
            txtEmployeeJobTitle;

    JButton btnSave;

    Connection connection;

    Statement statement;

    public AddEmployee(Connection connection){

        super("Add Employee", false, true, true, true );
        setBounds(400, 30, 600, 500);
        setFrameIcon(new ImageIcon("resources\\icons8_user.png"));


        this.connection = connection;


        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Font font = new Font("Malgun Gothic", Font.PLAIN, 18);


        lblEmployeeID = new JLabel("Employee ID");
        lblEmployeeID.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeID, gridBagConstraints);



        txtEmployeeID = new JTextField();
        txtEmployeeID.setText(generateID());
        txtEmployeeID.setEditable(false);
        txtEmployeeID.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeID, gridBagConstraints);


        lblEmployeeName = new JLabel("Full Name");
        lblEmployeeName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeName, gridBagConstraints);

        txtEmployeeName = new JTextField();
        txtEmployeeName.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeName, gridBagConstraints);



        lblEmployeeEmail = new JLabel("Email");
        lblEmployeeEmail.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeEmail, gridBagConstraints);

        txtEmployeeEmail = new JTextField();
        txtEmployeeEmail.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeEmail, gridBagConstraints);


        lblEmployeePhone = new JLabel("Mobile Number");
        lblEmployeePhone.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeePhone, gridBagConstraints);

        txtEmployeePhone = new JTextField();
        txtEmployeePhone.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeePhone, gridBagConstraints);

        lblEmployeeGender = new JLabel("Gender");
        lblEmployeeGender.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeGender, gridBagConstraints);

        txtEmployeeGender = new JTextField();
        txtEmployeeGender.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeGender, gridBagConstraints);

        lblEmployeeJobTitle = new JLabel("Job Title");
        lblEmployeeJobTitle.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(lblEmployeeJobTitle, gridBagConstraints);

        txtEmployeeJobTitle = new JTextField();
        txtEmployeeJobTitle.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(txtEmployeeJobTitle, gridBagConstraints);

        btnSave = new JButton("Save");
        btnSave.setFont(font);
        btnSave.setBackground(Color.BLUE);
        btnSave.setForeground(Color.WHITE);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        btnSave.addActionListener(e -> {

            String Id = txtEmployeeID.getText();
            String name = txtEmployeeName.getText();
            String email = txtEmployeeEmail.getText();
            String mobile = txtEmployeePhone.getText();
            String gender = txtEmployeeGender.getText();
            String jobTitle = txtEmployeeJobTitle.getText();

            if(e.getSource() == btnSave){
                try {

                    statement = this.connection.createStatement();

                    String insert = "insert into employees (employee_id, full_name, email," +
                            " mobile, gender, job_title)" +
                            " values('"+Id+"', '"+name+"', '"+email+"', '"+mobile+"', '"+gender+"', '"+jobTitle+"')";

                    int rowsAffected = statement.executeUpdate(insert);

                    JOptionPane.showMessageDialog(null, rowsAffected +  " Employee Added Successfully.");

                    dispose();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
        add(btnSave, gridBagConstraints);

        setVisible(true);

    }
    public String generateID(){

        String [] numbers = {"1","2","3","4","5","6","7","8","9"};

        StringBuilder generatedID = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = (int)  Math.floor(Math.random() * numbers.length );
            generatedID.append(numbers[index]);

        }
        return "EMP" + generatedID;
    }

}
