package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class BoardController {

    private final Board board;
    private final Driver driver = new Driver();

    public BoardController(Board board) {
        this.board = board;
        board.getOkButton().addActionListener(this::onOkPressed);
    }


    private void onOkPressed(ActionEvent e) {
        String link = board.getLinkField().getText().trim();

        if(link.isEmpty()) {
            JOptionPane.showMessageDialog(board, "Please enter a GitHub link");
            return;
        }

        try {
            driver.readUrl(link);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(board, "Error reading GitHub: " + ex.getMessage());
        }

        List<String> files = Blackboard.getInstance().getData();

        System.out.println("Number of files: " + files.size());

        JPanel filePanel = board.getFilePanel();
        filePanel.removeAll();

        for (String file : files) {
            JPanel box = new JPanel();
            box.setPreferredSize(new Dimension(150, 50)); // make sure visible
            box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            box.setBackground(new Color(173, 216, 230));
            box.add(new JLabel(file));
            filePanel.add(box);
        }

        filePanel.revalidate();
        filePanel.repaint();
    }
}
