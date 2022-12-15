package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.controller.game.TrainController;
import com.ldts.frogger.controller.game.TruckController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainControllerTest {
    private TrainController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            arena = new Arena(20, 20);
            frog = new Frog(5, 5);
            arena.setFrog(frog);
            arena.setSidewalks(Arrays.asList(new Sidewalk(3, 4)));
            arena.setGrasses(Arrays.asList(new Grass(7, 8)));
            arena.setCars(Arrays.asList(new Car(8, 7)));
            arena.setTrucks(Arrays.asList(new Truck(8, 7)));
            arena.setVans(Arrays.asList(new Van(8, 7)));
            arena.setTrees(Arrays.asList(new Tree(9, 7)));
            arena.setWaters(Arrays.asList());
            controller = new TrainController(arena);

            game = Mockito.mock(Game.class);
        }
    }

    @Test
    void moveTrains() throws IOException {
        Train t1 = new Train(new Position(5,5),1);
        Train t2 = new Train(new Position(9, 6), 0);
        arena.setTrains(Arrays.asList(t1, t2));
        controller.step(game, GUI.ACTION.NONE, 1000);
        assertEquals(new Position(6,5), t1.getPosition());
        assertEquals(new Position(8,6), t2.getPosition());
    }

    @Test
    void moveTrainsAgainstWall() throws IOException {
        Train t1 = new Train(new Position(19,5),1);
        Train t2 = new Train(new Position(-17, 6), 0);
        arena.setTrains(Arrays.asList(t1, t2));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(new Position(-30,5), t1.getPosition());
        assertEquals(new Position(30,6), t2.getPosition());
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        Train t = new Train(new Position(4, 5),1);
        arena.setTrains(Arrays.asList(t));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        Train t = new Train(new Position(6, 5),1);
        arena.setTrains(Arrays.asList(t));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.RIGHT, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }
    @Test
    void checkCrashWithFrogMovingLeft() throws IOException {
        Train t = new Train(new Position(2, 5),1);
        arena.setTrains(Arrays.asList(t));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.LEFT, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        Train t = new Train(new Position(3, 4),1);
        arena.setTrains(Arrays.asList(t));
        frog = new Frog(10, 4);
        arena.setFrog(frog);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.UP, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingDown() throws IOException {
        Train t = new Train(new Position(3, 6),1);
        arena.setTrains(Arrays.asList(t));
        frog = new Frog(18, 6);
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.DOWN, 2000);
        assertTrue(frog.getLives() < 3);
    }

}
