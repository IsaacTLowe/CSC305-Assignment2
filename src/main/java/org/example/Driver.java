package org.example;

import javiergs.tulip.GitHubHandler;

import java.io.IOException;
import java.util.*;

public class Driver {
    private String token = "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";
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



        System.out.println(Blackboard.getInstance().getFileData());

    }

}
