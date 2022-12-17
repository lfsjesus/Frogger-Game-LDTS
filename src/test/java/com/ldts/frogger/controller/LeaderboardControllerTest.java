package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.menu.LeaderboardController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.states.LeaderboardState;
import com.ldts.frogger.states.MenuState;
import com.ldts.frogger.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaderboardControllerTest {
    private Game game;
    private Leaderboard lb;
    private LeaderboardController controller;

    @BeforeEach
    void setUp() throws IOException{
        game = new Game(Mockito.mock(LanternaGUI.class));
        lb = Mockito.mock(Leaderboard.class);
        State state = Mockito.mock(LeaderboardState.class);
        game.setState(state);
        controller = new LeaderboardController(lb);
    }

    @Test
    void checkIsSelectedExit() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 500);
        assertTrue(game.getState() instanceof MenuState);

    }

    @Test
    void checkStateNotNull()  {
        assertTrue(game.getState() instanceof LeaderboardState);
    }

}
