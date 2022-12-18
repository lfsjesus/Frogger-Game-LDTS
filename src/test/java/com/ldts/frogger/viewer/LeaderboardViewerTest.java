package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.viewer.menu.LeaderboardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LeaderboardViewerTest {
    private Leaderboard leaderboard;
    private LeaderboardViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() throws IOException {
        leaderboard = Mockito.mock(Leaderboard.class);;
        viewer = new LeaderboardViewer(leaderboard);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawLeaderboardElements() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(400)).drawBackground(Mockito.any(), Mockito.anyString());
        Mockito.verify(gui, Mockito.times(3)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
    }
}
