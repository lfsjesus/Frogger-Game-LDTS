package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.GameFinishedController;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.game.GameViewer;
import com.ldts.frogger.viewer.menu.GameFinishedViewer;
import com.ldts.frogger.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameFinishedStateTest {
    private Game game;
    private GameFinished menu;
    private LanternaGUI gui;
    private GameFinishedController controller;

    @BeforeEach
    void setUp() {
        menu = new GameFinished(true);
        gui = Mockito.mock(LanternaGUI.class);
        game = new Game(gui);
        game.setState(new GameFinishedState(menu));
        controller = new GameFinishedController(menu);
    }

    @Test
    void testMenuStateViewer() {
        assertTrue(game.getState().getViewer() instanceof GameFinishedViewer);
    }

    @Test
    void testMenuStateController() {
        assertTrue(game.getState().getController() instanceof GameFinishedController);
    }

    @Test
    void changeState() throws IOException {
        controller.step(game, GUI.ACTION.SELECT, 300);
        assertTrue(game.getState().getController() instanceof ArenaController && game.getState().getViewer() instanceof GameViewer);
    }

    @Test
    void getModel() {
        assertTrue(game.getState().getModel() instanceof GameFinished);
    }
}
