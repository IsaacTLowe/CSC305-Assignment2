package org.example;

import java.util.*;

/**
 * handles all data for the program
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class Blackboard {
    private static Blackboard instance;
    private List<String> file;
    private List<String> fileData;
    private int length;
    private int complexity;

    private Blackboard() {
        file = new ArrayList<String>();
        fileData = new ArrayList<String>();
    }

    public static Blackboard getInstance() {
        if (instance == null) {
            instance = new Blackboard();
        }
        return instance;
    }

    public void setFile(List<String> data) {
        this.file = data;
    }

    public List<String> getFile() {
        return file;
    }

    public void addFileData(String data) {
        if (fileData == null) {
            fileData = new ArrayList<>();
        }
        fileData.add(data);
    }

    public List<String> getFileData() { return fileData; }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }
}