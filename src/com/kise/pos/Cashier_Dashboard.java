package com.kise.pos;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Cashier_Dashboard extends JFrame {
    Connection connection;
    JMenuBar menuBar;
    JDesktopPane desktopPane;
    JMenu pointOfSaleMenu, settingsMenu;
    JMenuItem pointOfSale, logout;

    Cashier_Dashboard(Connection connection){
        super("Dashboard");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("resources\\logo.png").getImage());

        this.connection = connection;
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        DesktopManager desktopManager = new DefaultDesktopManager();
        desktopPane = new JDesktopPane();
        desktopPane.setDesktopManager(desktopManager);

        pointOfSaleMenu = new JMenu("Point of Sale");
        menuBar.add(pointOfSaleMenu);

        settingsMenu = new JMenu("Settings");
        menuBar.add(settingsMenu);

        pointOfSale = new JMenuItem("POI");
        pointOfSale.addActionListener(e -> desktopPane.add(new POS_UI(this.connection)));
        pointOfSaleMenu.add(pointOfSale);

        logout = new JMenuItem("Logout");
        logout.addActionListener(e -> {
            dispose();
            new Login();
        });
        settingsMenu.add(logout);

        add(desktopPane, BorderLayout.CENTER);
        setVisible(true);

    }
}
