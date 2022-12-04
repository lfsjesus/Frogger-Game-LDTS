package com.ldts.frogger.model.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    }

    @Override
    public String getEntry(int i) {
        return lines.get(i);
    }

    public List<String> getLines() {
        return lines;
    }
}
