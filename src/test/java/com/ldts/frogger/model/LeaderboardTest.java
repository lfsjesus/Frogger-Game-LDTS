package com.ldts.frogger.model;

import com.ldts.frogger.model.menu.Leaderboard;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LeaderboardTest {
    public LeaderboardTest() throws IOException {
    }
    private Leaderboard lb = new Leaderboard();



    @Test
    public void readFile() throws IOException {
        lb.readLeaderboard();
    }


}
