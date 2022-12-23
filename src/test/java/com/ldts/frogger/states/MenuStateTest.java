package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.game.GameViewer;
import com.ldts.frogger.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuStateTest {
    private Game game;
    private Menu menu;
    private LanternaGUI gui;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        gui = Mockito.mock(LanternaGUI.class);
        game = new Game(gui);
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
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            controller.step(game, GUI.ACTION.SELECT, 300);
            assertTrue(game.getState().getController() instanceof ArenaController && game.getState().getViewer() instanceof GameViewer);
        }
    }

    @Test
    void getModel() {
        assertTrue(game.getState().getModel() instanceof Menu);
    }

}
