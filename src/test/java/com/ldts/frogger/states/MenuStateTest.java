package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.game.GameViewer;
import com.ldts.frogger.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuStateTest {
    private Game game;
    private Menu menu;
    private State state;

    private Arena arena;
    private GUI gui;
    private MenuController controller;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new Menu();
        arena = Mockito.mock(Arena.class);
        gui = Mockito.mock(GUI.class);
        game = new Game();
        game.setState(new MenuState(menu));
        controller = new MenuController(menu);
    }

    @Test
    void testMenuStateViewer() {
        assertTrue(game.getState().getViewer() instanceof MenuViewer);
    }

    @Test
    void testMenuStateController() {
        assertTrue(game.getState().getController() instanceof MenuController);
    }

    @Test
    void changeState() throws IOException {
        controller.step(game, GUI.ACTION.SELECT, 300);
        assertTrue(game.getState().getController() instanceof ArenaController && game.getState().getViewer() instanceof GameViewer);
    }

}
