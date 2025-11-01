package org.example;

import java.util.List;

/**
 * analyzes the files and sends data to the blackboard to store
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class FileAnalyzer {

    public static void analyze(String fileData) {
        Blackboard blackboard = Blackboard.getInstance();

        List<String> lines = List.of(fileData.split("\n"));
        int size = lines.size();
        int complexity = 0;

        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.contains("if") || trimmed.contains("for") ||
                    trimmed.contains("while") || trimmed.contains("switch")) {
                complexity++;
            }
        }

        blackboard.setLength(size);
        blackboard.setComplexity(complexity);
    }
}
