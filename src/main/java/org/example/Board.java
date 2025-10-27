package org.example;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private JTextField linkField;
    private JButton okButton;
    private JPanel filePanel;
    private JLabel fileName;

    public Board() {
        setTitle("Git File Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        linkField = new JTextField("");
        okButton = new JButton("OK");

        topPanel.add(linkField, BorderLayout.CENTER);
        topPanel.add(okButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 25));
        filePanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JScrollPane scrollPane = new JScrollPane(filePanel);
        add(scrollPane, BorderLayout.CENTER);

        fileName = new JLabel("");
        add(fileName, BorderLayout.SOUTH);
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

    public JLabel getFileName() { return fileName; }

}
