package com.kise.pos;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class Receipt extends JDialog {

    POS_UI pos_ui = new POS_UI();

    JTextArea txtReceipt;
    JButton btnPrint;

    Receipt() {
        super((Frame) null, "Receipt");
        setSize(500, 500);
        setDefaultLookAndFeelDecorated(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        txtReceipt = pos_ui.populateReceipt();

        add(txtReceipt, BorderLayout.CENTER);

        btnPrint = new JButton("Print");
        btnPrint.setBackground(Color.BLUE);
        btnPrint.setForeground(Color.WHITE);
        btnPrint.addActionListener(e -> {
            try {
                txtReceipt.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnPrint.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
        add(btnPrint, BorderLayout.SOUTH);
        setVisible(true);
    }
}
