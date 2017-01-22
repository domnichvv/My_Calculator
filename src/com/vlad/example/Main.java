package com.vlad.example.gui;

import com.jtattoo.plaf.mint.MintLookAndFeel;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MintLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        GUI testGUI = new GUI();

        testGUI.createButtons();
        testGUI.createLabels();
        testGUI.createTextField();
        testGUI.createPanels();
        testGUI.createFrame();
    }
}