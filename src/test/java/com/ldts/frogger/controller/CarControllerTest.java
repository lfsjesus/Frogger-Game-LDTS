package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.CarController;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarControllerTest {
    private CarController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        frog = new Frog(5, 5);
        Frog.setLives(3);
        arena.setFrog(frog);
        controller = new CarController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveCars() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car1 = new Car(new Position(5, 5), 1);
            Car car2 = new Car(new Position(9, 6), 0);
            arena.setCars(Arrays.asList(car1, car2));
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), car1.getPosition());
            assertEquals(new Position(8, 6), car2.getPosition());
        }
    }

    @Test
    void moveCarAgainstWall() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car1 = new Car(new Position(9, 5), 1);
            Car car2 = new Car(new Position(-1, 5), 0);
            arena.setCars(Arrays.asList(car1, car2));
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertEquals(new Position(-1, 5), car1.getPosition());
            assertEquals(new Position(9, 5), car2.getPosition());
        }
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car = new Car(new Position(4, 5), 1);
            arena.setCars(List.of(car));
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car = new Car(new Position(6, 5), 1);
            arena.setCars(List.of(car));
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
            Car car = new Car(new Position(2, 5), 1);
            arena.setCars(List.of(car));
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.LEFT, 2000);
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car = new Car(new Position(3, 4), 1);
            arena.setCars(List.of(car));
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
            Car car = new Car(new Position(3, 6), 1);
            arena.setCars(List.of(car));
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.DOWN, 2000);
            controller.step(game, GUI.ACTION.NONE, 2000);
            assertTrue(Frog.getLives() < 3);
        }
    }

    @Test
    void checkFrogDidNotCrash() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Car car = new Car(new Position(2, 6), 1);
            arena.setCars(List.of(car));
            controller.step(game, GUI.ACTION.NONE, 300);
            FrogController frogController = new FrogController(arena);
            frogController.step(game, GUI.ACTION.NONE, 2000);
            assertEquals(3, Frog.getLives());
        }
    }


}
