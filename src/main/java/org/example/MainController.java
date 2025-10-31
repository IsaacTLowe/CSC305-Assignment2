package org.example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class MainController {

    private final Board board;

    public MainController(Board board) {
        this.board = board;
    }

    public void fileClicked(String fileName) {
        board.getFileName().setText("Selected file: " + fileName);
    }

    public void attachClickListener(javax.swing.JPanel panel, String fileName) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fileClicked(fileName);
            }
        });
    }
}
