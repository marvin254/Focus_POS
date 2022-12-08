package com.kise.pos;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class Splash_Screen extends JWindow {

    JProgressBar progressBar;

    Splash_Screen() {
        createGUI();

        createProgressBar();

        loader();
    }

    public void createGUI() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.WHITE);



        setContentPane(new JLabel(new ImageIcon("resources\\splash.png")));


        setVisible(true);

    }

    public void createProgressBar() {
        progressBar = new JProgressBar();
        progressBar.setBounds(5, 270, 580, 20);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.cyan);
        progressBar.setIndeterminate(true);

        add(progressBar);

    }

    public void loader() {

        for (int i = 0; i <= 100; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            progressBar.setValue(i);

            if (i == 100) {
                dispose();
                new Login();
            }

        }

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        new Splash_Screen();
    }
}
