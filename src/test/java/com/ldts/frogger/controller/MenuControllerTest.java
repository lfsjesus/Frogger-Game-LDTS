package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.LeaderboardState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MenuControllerTest {
    private Game game;
    private Menu menu;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        game = new Game(Mockito.mock(LanternaGUI.class));
        menu = new Menu();
        controller = new MenuController(menu);
    }

    @Test
    void checkArrowDown() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(1));
    }

    @Test
    void checkArrowUp() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(1));
        controller.step(game, GUI.ACTION.UP, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(0));
    }

    @Test
    void checkIsSelectedExit() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        controller.step(game, GUI.ACTION.DOWN, 500);
        controller.step(game, GUI.ACTION.SELECT, 500);
        assertNull(game.getState());

    }

    @Test
    void checkStateNotNull() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        controller.step(game, GUI.ACTION.SELECT, 500);
        assertTrue(game.getState() instanceof LeaderboardState);
    }

    @Test
    void checkGameStart() throws IOException {
        Arena.setPoints(2);
        Frog.setLives(2);
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            controller.step(game, GUI.ACTION.SELECT, 500);
            assertTrue(game.getState() instanceof GameState);
            assertEquals(3, Frog.getLives());
            assertEquals(0, Arena.getPoints());
        }

    }


}
