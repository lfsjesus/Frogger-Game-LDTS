package com.ldts.frogger.model;

import com.ldts.frogger.model.menu.Leaderboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {
    private Leaderboard leaderboard;

    @BeforeEach
    void setUp() throws IOException {
        leaderboard = new Leaderboard();
    }

    @Test
    public void readLeaderboard() {
        assertNotNull(leaderboard);
    }

    @Test
    public void addRecord() throws IOException{
        List<String> list = leaderboard.readLeaderboard();
        leaderboard.addRecord(200, "test");
        List<String> updatedList = leaderboard.readLeaderboard();
        boolean isAdded = false;
        for (String s : updatedList) {
            if (s.equals("00200 test")) {
                isAdded = true;
                break;
            }
        }
        assertTrue(isAdded);
        leaderboard.setEntries(list);
        leaderboard.writeToFile();;
    }

    @Test
    public void getEntry() throws IOException{
        List<String> list = leaderboard.readLeaderboard();
        leaderboard.addRecord(0, "zzz");
        List<String> updatedList = leaderboard.readLeaderboard();
        assertEquals(leaderboard.getEntry(0), updatedList.get(0));
        leaderboard.setEntries(list);
        leaderboard.writeToFile();;
    }

    @Test
    public void getLines() throws IOException{
        List<String> list = leaderboard.readLeaderboard();
        List<String> updatedList = Arrays.asList("00000 test");
        leaderboard.setEntries(updatedList);
        leaderboard.writeToFile();
        assertEquals(leaderboard.getLines(), updatedList);
        leaderboard.setEntries(list);
        leaderboard.writeToFile();;
    }

    @Test
    public void order() throws IOException{
        List<String> list = leaderboard.readLeaderboard();
        leaderboard.setEntries(new ArrayList<>());
        leaderboard.writeToFile();
        leaderboard.addRecord(1, "zzz");
        leaderboard.addRecord(2, "zzz");
        List<String> finalList = Arrays.asList("00002 zzz", "00001 zzz");
        List<String> updatedList = leaderboard.readLeaderboard();
        assertEquals(finalList, updatedList);
        leaderboard.setEntries(list);
        leaderboard.writeToFile();;
    }

}
