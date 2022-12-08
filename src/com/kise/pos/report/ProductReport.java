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

public class ProductReport extends JInternalFrame {
    Connection connection;
    JRViewer jrViewer;
    public ProductReport(Connection connection) throws FileNotFoundException {
        super("Product Report", false, true, true, true);
        setBounds(84, 30, 1200, 600);
        setFrameIcon(new ImageIcon("resources\\icons8_report.png"));

        this.connection = connection;

        InputStream inputStream = new FileInputStream("resources//jasperReports\\Products_Report.jrxml");
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, this.connection);
            jrViewer = new JRViewer(jasperPrint);

            add(jrViewer);

        } catch (JRException e ) {
            throw new RuntimeException(e);
        }
        setVisible(true);
    }
}
