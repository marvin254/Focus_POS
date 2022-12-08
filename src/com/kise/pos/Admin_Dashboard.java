package com.kise.pos;

import com.kise.pos.employee.*;
import com.kise.pos.product.*;
import com.kise.pos.report.EmployeeReport;
import com.kise.pos.report.ProductReport;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.Connection;

public class Admin_Dashboard extends JFrame {

    Connection connection;

    JMenuBar menuBar;

    JDesktopPane desktopPane;

    JMenu pointOfSaleMenu, employeeMenu, productMenu, reportMenu, settingsMenu;

    JMenuItem pointOfSale, searchEmployee, addEmployee, updateEmployee, deleteEmployee, viewAllEmployees,
    searchProduct, addProduct, updateProduct, deleteProduct, viewAllProducts,
    employeeReport, productReport,
    logoutMenuItem;

    Admin_Dashboard(Connection connection) {
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

        loadMenus();

        loadMenuItems();


        add(desktopPane, BorderLayout.CENTER);
        setVisible(true);

    }

    public void loadMenus() {

        pointOfSaleMenu = new JMenu("Point of Sale");
        menuBar.add(pointOfSaleMenu);

        employeeMenu = new JMenu("Employees");
        menuBar.add(employeeMenu);

        productMenu = new JMenu("Products");
        menuBar.add(productMenu);

        reportMenu = new JMenu("Reports");
        menuBar.add(reportMenu);

        settingsMenu = new JMenu("Settings");
        menuBar.add(settingsMenu);

    }

    public void loadMenuItems() {
//        POI_UI
        pointOfSale = new JMenuItem("POI");
        pointOfSale.addActionListener(e -> desktopPane.add(new POS_UI(this.connection)));
        pointOfSaleMenu.add(pointOfSale);


//        EMPLOYEE

        searchEmployee = new JMenuItem("Search Employee");
        searchEmployee.addActionListener(e -> desktopPane.add(new SearchEmployee(this.connection)));
        employeeMenu.add(searchEmployee);

        addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(e -> {
            if (e.getSource() == addEmployee) {
                desktopPane.add(new AddEmployee(this.connection));

            }

        });
        employeeMenu.add(addEmployee);

        updateEmployee = new JMenuItem("Update Employee");
        updateEmployee.addActionListener(e -> desktopPane.add(new UpdateEmployee(this.connection)));
        employeeMenu.add(updateEmployee);

        deleteEmployee = new JMenuItem("Delete Employee");
        deleteEmployee.addActionListener(e -> desktopPane.add(new DeleteEmployee(this.connection)));
        employeeMenu.add(deleteEmployee);


        viewAllEmployees = new JMenuItem("View All Employees");
        viewAllEmployees.addActionListener(e -> {
            if (e.getSource() == viewAllEmployees) {
                desktopPane.add(new AllEmployees(this.connection));
            }

        });
        employeeMenu.add(viewAllEmployees);


//        PRODUCT

        searchProduct = new JMenuItem("Search Product");
        searchProduct.addActionListener(e -> desktopPane.add(new SearchProduct(this.connection)));
        productMenu.add(searchProduct);

        addProduct = new JMenuItem("Add Product");
        addProduct.addActionListener(e -> {
            if (e.getSource() == addProduct) {
                desktopPane.add(new AddProduct(this.connection));
            }
        });
        productMenu.add(addProduct);

        updateProduct = new JMenuItem("Update Product");
        updateProduct.addActionListener(e -> desktopPane.add(new UpdateProduct(this.connection)));
        productMenu.add(updateProduct);

        deleteProduct = new JMenuItem("Delete Product");
        deleteProduct.addActionListener(e -> desktopPane.add(new DeleteProduct(this.connection)));
        productMenu.add(deleteProduct);


        viewAllProducts = new JMenuItem("View All Products");
        viewAllProducts.addActionListener(e -> {
            if (e.getSource() == viewAllProducts) {
                desktopPane.add(new AllProducts(this.connection));
            }

        });
        productMenu.add(viewAllProducts);


//        REPORTS
        employeeReport = new JMenuItem("Employee Report");
        employeeReport.addActionListener(e -> desktopPane.add(new EmployeeReport(this.connection)));
        reportMenu.add(employeeReport);

        productReport = new JMenuItem("Product Report");
        productReport.addActionListener(e -> {
            try {
                desktopPane.add(new ProductReport(this.connection));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        reportMenu.add(productReport);

//        SETTINGS
        logoutMenuItem = new JMenuItem("Logout");
        logoutMenuItem.addActionListener(e -> {
            dispose();
            new Login();
        });
        settingsMenu.add(logoutMenuItem);
    }

}
