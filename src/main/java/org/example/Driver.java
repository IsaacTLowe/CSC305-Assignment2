package org.example;

import javiergs.tulip.GitHubHandler;

import java.io.IOException;
import java.util.*;

public class Driver {
    private String token = "";
    private GitHubHandler gh = new GitHubHandler(token);

    public void readUrl(String url) throws IOException {
        List<String> all = gh.listFilesRecursive(url);
        Blackboard.getInstance().setData(all);
    }
}
