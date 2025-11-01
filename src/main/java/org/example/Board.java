package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * displays a board with various actions
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

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

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Action");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem openItem = new JMenuItem("Open from URL");
        JMenuItem closeItem = new JMenuItem("Exit");

        JMenuItem reloadItem = new JMenuItem("Reload");
        JMenuItem clearItem = new JMenuItem("Clear");

        JMenuItem aboutItem = new JMenuItem("About");

        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        editMenu.add(reloadItem);
        helpMenu.add(clearItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);


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