package org.example;

import javiergs.tulip.GitHubHandler;

import java.io.IOException;
import java.util.*;

/**
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class Driver {
    private String token = "";
    private GitHubHandler gh = new GitHubHandler(token);

    public void readUrl(String url) throws IOException {
        List<String> file = gh.listFiles(url);
        Blackboard.getInstance().setFile(file);

        if (url.endsWith("src")) {
            url = url.substring(0, url.length() - 3);
        }

        for (int i = 0; i < file.size(); i++) {
            String fileUrl = url.replace("tree", "blob") + file.get(i);
            String content = gh.getFileContentFromUrl(fileUrl);
            Blackboard.getInstance().addFileData(content);
        }

    }

}