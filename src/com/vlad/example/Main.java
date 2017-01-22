package com.vlad.example;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.vlad.example.view_controller.CalculationGUI;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new GraphiteLookAndFeel()); //скин окна
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculationGUI();
            }
        });
    }
}