package org.example;

import java.util.*;

public class Blackboard {
    private static Blackboard instance;
    private List<String> data;
    private int rating;

    private Blackboard() {
        data = new ArrayList<String>();
    }

    public static Blackboard getInstance() {
        if (instance == null) {
            instance = new Blackboard();
        }
        return instance;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
