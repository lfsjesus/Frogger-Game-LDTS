package com.ldts.frogger.model;

import com.ldts.frogger.model.menu.LeaderboardDisplay;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LeaderboardTest {
    public LeaderboardTest() throws IOException {
    }
    private LeaderboardDisplay lb = new LeaderboardDisplay();



    @Test
    public void readFile() throws IOException {
        lb.readLeaderboard();
    }


}
