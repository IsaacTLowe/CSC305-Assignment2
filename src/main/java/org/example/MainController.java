package org.example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainController {

    private final Board board;

    public MainController(Board board) {
        this.board = board;
    }

    // Call this method when a file panel is clicked
    public void fileClicked(String fileName) {
        board.getFileName().setText("Selected file: " + fileName);
    }

    // Helper method to attach a mouse listener to a JPanel square
    public void attachClickListener(javax.swing.JPanel panel, String fileName) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fileClicked(fileName);
            }
        });
    }
}
