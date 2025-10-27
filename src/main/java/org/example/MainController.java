package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private final Board board;

    public MainController(Board board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = e.getActionCommand();
        board.getFileName().setText("Selected file: " + fileName);
    }
}
