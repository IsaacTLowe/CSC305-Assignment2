package org.example;

import javax.swing.*;

/**
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        Board board = new Board();
        board.setVisible(true);
    }
}
