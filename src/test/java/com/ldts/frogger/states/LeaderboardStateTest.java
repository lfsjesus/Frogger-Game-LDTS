package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.menu.LeaderboardController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.viewer.menu.LeaderboardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderboardStateTest {

    private Game game;
    private Leaderboard leaderboard;
    private LanternaGUI gui;
    private LeaderboardController controller;

    @BeforeEach
    void setUp() throws IOException {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            leaderboard = new Leaderboard();
            gui = Mockito.mock(LanternaGUI.class);
            game = new Game(gui);
            game.setState(new LeaderboardState(leaderboard));
            controller = new LeaderboardController(leaderboard);
        }
    }

    @Test
    void testMenuStateViewer() {
        assertTrue(game.getState().getViewer() instanceof LeaderboardViewer);
    }

    @Test
    void testMenuStateController() {
        assertTrue(game.getState().getController() instanceof LeaderboardController);
    }

    @Test
    void changeState() throws IOException {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            controller.step(game, GUI.ACTION.SELECT, 300);
            assertTrue(game.getState().getController() instanceof LeaderboardController && game.getState().getViewer() instanceof LeaderboardViewer);
        }
    }

    @Test
    void getModel() {
        assertTrue(game.getState().getModel() instanceof Leaderboard);
    }
}
