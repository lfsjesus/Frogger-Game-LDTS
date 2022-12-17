package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.game.GameViewer;
import com.ldts.frogger.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {

    private Game game;
    private Menu menu;
    private Arena arena;
    private LanternaGUI gui;
    private ArenaController controller;


    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new Menu();
        arena = Mockito.mock(Arena.class);
        gui = Mockito.mock(LanternaGUI.class);
        game = new Game(gui);
        Arena.setPoints(0);
        Frog.setLives(3);
        game.setState(new GameState(arena));
        controller = new ArenaController(arena);
    }

    @Test
    void testMenuStateViewer() {
        assertTrue(game.getState().getViewer() instanceof GameViewer);
    }

    @Test
    void testMenuStateController() {
        assertTrue(game.getState().getController() instanceof ArenaController);
    }

    @Test
    void changeState() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 300);
        assertTrue(game.getState().getController() instanceof MenuController && game.getState().getViewer() instanceof MenuViewer);
    }

    @Test
    void testState() {
        State state = Mockito.mock(State.class);
        game.setState(state);
        assertEquals(state, game.getState());
    }

    @Test
    void gameStarted() throws IOException {
        boolean score = Arena.getPoints() == 0;
        boolean lives = Frog.getLives() == 3;
        Assertions.assertTrue(score && lives);
    }

}
