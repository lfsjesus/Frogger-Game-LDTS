package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.controller.game.TrainController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainControllerTest {
    private TrainController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        frog = new Frog(5, 5);
        arena.setFrog(frog);
        Frog.setLives(3);
        controller = new TrainController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveTrains() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t1 = new Train(new Position(5, 5), 1);
            Train t2 = new Train(new Position(9, 6), 0);
            arena.setTrains(Arrays.asList(t1, t2));
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), t1.getPosition());
            assertEquals(new Position(8, 6), t2.getPosition());
        }
    }

    @Test
    void moveTrainsAgainstWall() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t1 = new Train(new Position(19, 5), 1);
            Train t2 = new Train(new Position(-17, 6), 0);
            arena.setTrains(Arrays.asList(t1, t2));
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertEquals(new Position(-30, 5), t1.getPosition());
            assertEquals(new Position(30, 6), t2.getPosition());
        }
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(4, 5), 1);
            arena.setTrains(List.of(t));
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(6, 5), 1);
            arena.setTrains(List.of(t));
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.RIGHT, 2000);
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingLeft() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(2, 5), 1);
            arena.setTrains(List.of(t));
            controller.step(game, GUI.ACTION.NONE, 2000);
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.LEFT, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(3, 3), 1);
            arena.setTrains(List.of(t));
            frog = new Frog(10, 4);
            arena.setFrog(frog);
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.UP, 2000);
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingDown() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(5, 6), 1);
            arena.setTrains(List.of(t));
            frog = new Frog(18, 4);
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.DOWN, 2000);
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void frogDidNotCrash() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Train t = new Train(new Position(3, 6), 1);
            arena.setTrains(List.of(t));
            frog = new Frog(18, 5);
            controller.step(game, GUI.ACTION.NONE, 2000);
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.RIGHT, 2000);
            assertEquals(3, Frog.getLives());
        }
    }

}
