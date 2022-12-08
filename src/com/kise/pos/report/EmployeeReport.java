package com.kise.pos.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;

public class EmployeeReport extends JInternalFrame {
    JRViewer jrViewer;
    Connection connection;
    public EmployeeReport(Connection connection) {
        super("Product Report", false, true, true, true);
        setBounds(84, 30, 1200, 600);
        setFrameIcon(new ImageIcon("images\\icons8_report.png"));

        this.connection = connection;

        try {
            InputStream inputStream = new FileInputStream("jasperReports\\Employees_Report.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, this.connection);
            jrViewer = new JRViewer(jasperPrint);
            add(jrViewer);
        } catch (JRException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
    }
}
