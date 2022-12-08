package com.kise.pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Login extends JFrame implements ActionListener {
    JLabel lblLogin;
    JComboBox<String> cbUser;
    JPasswordField passwordField;
    JButton btnLogin;
    String[] users = {"Select user role", "admin", "cashier"};
    String user;
    Login() {
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setBackground(Color.white);
        setIconImage(new ImageIcon("images\\logo.png").getImage());

        Font font = new Font("Malgun Gothic", Font.BOLD, 16);

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        lblLogin = new JLabel("Login to continue...", new ImageIcon("images\\logo.png"), JLabel.LEFT);
        lblLogin.setFont(new Font("Malgun Gothic", Font.ITALIC, 30));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.insets = new Insets(20, 500, 10, 500);
        add(lblLogin, gridBagConstraints);


        cbUser = new JComboBox<>(users);
        cbUser.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new Insets(20, 500, 10, 500);
        cbUser.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object obj = cbUser.getSelectedItem();
                String str = (String) obj;
                if (str != null) {
                    user = str;
                }

            }
        });


        add(cbUser, gridBagConstraints);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("Enter your Password");
        passwordField.setFont(font);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 5;

        add(passwordField, gridBagConstraints);

        btnLogin = new JButton("Login", new ImageIcon("images\\icons8_login.png"));
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        btnLogin.addActionListener(this);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 10;
        add(btnLogin, gridBagConstraints);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String password = String.valueOf(passwordField.getPassword());

        Object src = e.getSource();

        if (src == btnLogin) {

            ConnectionPool connectionPool = new ConnectionPool(user, password);

            if (connectionPool.createDatabaseConnection_2()) {
                if (user.equalsIgnoreCase("admin")) {
                    new Admin_Dashboard(connectionPool.connection);
                }
                if (user.equalsIgnoreCase("cashier")) {
                    new Cashier_Dashboard(connectionPool.connection);
                }
                JOptionPane.showMessageDialog(null, "Welcome, " + user.toUpperCase() + " to FOCUS POS");
                dispose();
            }

        }

    }

}
