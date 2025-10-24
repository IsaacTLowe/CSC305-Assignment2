package org.example;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private JTextField linkField;
    private JButton okButton;
    private JPanel filePanel;

    public Board() {
        setTitle("Git File Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        linkField = new JTextField("Enter GitHub link here...");
        okButton = new JButton("OK");

        topPanel.add(linkField, BorderLayout.CENTER);
        topPanel.add(okButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        filePanel = new JPanel(new GridLayout(0, 6, 10, 10));
        JScrollPane scrollPane = new JScrollPane(filePanel);
        add(scrollPane, BorderLayout.CENTER);

        new BoardController(this);

        setVisible(true);
    }

    public JTextField getLinkField() {
        return linkField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JPanel getFilePanel() {
        return filePanel;
    }

}
