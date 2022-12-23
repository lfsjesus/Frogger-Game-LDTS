package com.ldts.frogger.model.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard extends Menu {
    private List<String> lines;

    public Leaderboard() throws IOException {
        this.lines = readLeaderboard();
    }

    public List<String> readLeaderboard() throws IOException {
        List<String> lead = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/leaderboard.txt"));

        for (String line; (line = br.readLine()) != null; )
            lead.add(line);

        br.close();
        return lead;
    }

    public void addRecord(int score, String name) throws IOException {
        lines.add(String.format("%05d", score) + " " + name);
        lines.sort(Collections.reverseOrder());
        writeToFile();
    }

    public void writeToFile() throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("src/main/resources/leaderboard.txt"));
        for (int i = 0; i < lines.size() && i < 10; i++) {
            output.write(lines.get(i));
            output.newLine();
        }
        output.close();
    }

    @Override
    public String getEntry(int i) {
        return lines.get(i);
    }

    @Override
    public void setEntries(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
