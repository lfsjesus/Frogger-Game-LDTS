package com.ldts.frogger.states;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.controller.music.MusicManager;
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
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private Game game;
    private Menu menu;
    private Arena arena;
    private LanternaGUI gui;
    private ArenaController controller;


    @BeforeEach
    void setUp() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            menu = new Menu();
            arena = Mockito.mock(Arena.class);
            gui = Mockito.mock(LanternaGUI.class);
            game = new Game(gui);
            Arena.setPoints(0);
            Frog.setLives(3);
            game.setState(new GameState(arena));
            controller = new ArenaController(arena);
        }
    }

    @Test
    void testMenuStateViewer() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            assertTrue(game.getState().getViewer() instanceof GameViewer);
        }
    }

    @Test
    void testMenuStateController() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            assertTrue(game.getState().getController() instanceof ArenaController);
        }
    }

    @Test
    void changeState() throws IOException {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            controller.step(game, GUI.ACTION.QUIT, 300);
            assertTrue(game.getState().getController() instanceof MenuController && game.getState().getViewer() instanceof MenuViewer);
        }
    }

    @Test
    void testState() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            State state = Mockito.mock(State.class);
            game.setState(state);
            assertEquals(state, game.getState());
        }
    }

    @Test
    void gameStarted() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            boolean score = Arena.getPoints() == 0;
            boolean lives = Frog.getLives() == 3;
            Assertions.assertTrue(score && lives);
        }
    }

    @Test
    void getModel() {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            assertTrue(game.getState().getModel() instanceof Arena);
        }
    }

    @Test
    void drawFromState() throws IOException {
        MusicManager manager1 = Mockito.mock(MusicManager.class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager1);
            Frog frog = new Frog(1, 1);
            arena = new Arena(10, 10);
            arena.setFrog(frog);
            Controller<Arena> c = Mockito.mock(Controller.class);
            GameViewer v = Mockito.mock(GameViewer.class);
            State state = new GameState(arena, c, v);
            game.setState(state);
            game.getState().step(game, gui, 300);
            Mockito.verify(v, Mockito.times(1)).draw(gui);
        }
    }

}
