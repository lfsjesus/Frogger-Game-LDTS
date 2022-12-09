package com.ldts.frogger.model.menu;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderboardDisplay extends Menu{
    private List<String> lines;

    public LeaderboardDisplay() throws IOException{
        this.lines = new ArrayList<>();
        readLeaderboard();
    }
    public void readLeaderboard() throws IOException {
        URL resource = LeaderboardDisplay.class.getResource("/leaderboard.txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        java.util.Collections.sort(lines, Collections.reverseOrder());
    }

    public void addRecord(int score, String name) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("/leaderboard.txt", true));
        output.append(score + " " + name);
        output.close();
    }

    @Override
    public String getEntry(int i) {
        return lines.get(i);
    }

    public List<String> getLines() {
        return lines;
    }
}
