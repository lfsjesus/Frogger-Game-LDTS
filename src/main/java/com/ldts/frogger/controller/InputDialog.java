package com.ldts.frogger.controller;

import javax.swing.*;

public class InputDialog {
    private final String name;

    public InputDialog() {
        JFrame f = new JFrame();
        name = JOptionPane.showInputDialog(f, "Enter Name");
        f.dispose();
    }

    // For testing purposes
    public InputDialog(JFrame f, String name) {
        this.name = name;
        f.dispose();
    }

    public String getString() {
        return this.name;
    }

}
