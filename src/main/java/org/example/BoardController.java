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
    private final MainController mainController;

    public BoardController(Board board) {
        this.board = board;
        this.mainController = new MainController(board);
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

        List<String> files = Blackboard.getInstance().getFile();

        JPanel filePanel = board.getFilePanel();
        filePanel.removeAll();

        for (String file : files) {
            JButton box = new JButton();
            box.setPreferredSize(new Dimension(100, 100));
            box.setActionCommand(file);
            box.addActionListener(mainController);

            filePanel.add(box);
        }

        filePanel.revalidate();
        filePanel.repaint();
    }
}
