package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class BoardController {

    private final Board board;
    private final Driver driver = new Driver();
    private final MainController mainController;

    public BoardController(Board board) {
        this.board = board;
        this.mainController = new MainController(board);
        board.getOkButton().addActionListener(e -> onOkPressed());
    }

    private void onOkPressed() {
        String link = board.getLinkField().getText().trim();

        if (link.isEmpty()) {
            JOptionPane.showMessageDialog(board, "Please enter a GitHub link");
            return;
        }

        // Fetch files and file data from GitHub
        try {
            driver.readUrl(link);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(board, "Error reading GitHub: " + ex.getMessage());
            return;
        }

        List<String> files = Blackboard.getInstance().getFile();
        List<String> fileData = Blackboard.getInstance().getFileData();

        int maxSize = 0;
        for (String content : fileData) {
            FileAnalyzer.analyze(content); // updates Blackboard length & complexity
            int size = Blackboard.getInstance().getLength();
            if (size > maxSize) {
                maxSize = size;
            }
        }

        JPanel filePanel = board.getFilePanel();
        filePanel.removeAll();

        for (int i = 0; i < files.size(); i++) {
            String fileName = files.get(i);
            String content = fileData.get(i);

            FileAnalyzer.analyze(content);
            int complexity = Blackboard.getInstance().getComplexity();
            int size = Blackboard.getInstance().getLength();

            Color baseColor;
            if (complexity > 10) baseColor = Color.RED;
            else if (complexity > 5) baseColor = Color.YELLOW;
            else baseColor = Color.GREEN;

            int alpha = (maxSize == 0) ? 0 : (int) (255.0 * size / maxSize);
            alpha = Math.min(255, Math.max(0, alpha));

            Color boxColor = new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), alpha);

            JPanel square = new JPanel();
            square.setPreferredSize(new Dimension(100, 100));
            square.setBackground(boxColor);
            square.setOpaque(true);
            square.setToolTipText("Size: " + size + " lines, Complexity: " + complexity);

            square.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mainController.fileClicked(fileName);
                }
            });

            filePanel.add(square);
        }

        filePanel.revalidate();
        filePanel.repaint();
    }
}
