package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.controller.game.MotorbikeController;
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

public class MotorbikeControllerTest {
    private MotorbikeController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            arena = new Arena(10, 10);
            frog = new Frog(5, 5);
            arena.setFrog(frog);
            Frog.setLives(3);
            controller = new MotorbikeController(arena);

            game = Mockito.mock(Game.class);
        }
    }

    @Test
    void moveMotorbikes() throws IOException {
        Motorbike m1 = new Motorbike(new Position(5,5),1);
        Motorbike m2 = new Motorbike(new Position(9, 6), 0);
        arena.setMotorbikes(Arrays.asList(m1, m2));
        controller.step(game, GUI.ACTION.NONE, 1000);
        assertEquals(new Position(6,5), m1.getPosition());
        assertEquals(new Position(8,6), m2.getPosition());
    }

    @Test
    void moveMotorbikeAgainstWall() throws IOException {
        Motorbike m1 = new Motorbike(new Position(9,5),1);
        Motorbike m2 = new Motorbike(new Position(-1, 6), 0);
        arena.setMotorbikes(Arrays.asList(m1, m2));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(new Position(-1,5), m1.getPosition());
        assertEquals(new Position(9,6), m2.getPosition());
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        Motorbike m = new Motorbike(new Position(4, 5),1);
        arena.setMotorbikes(Arrays.asList(m));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(Frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        Motorbike m = new Motorbike(new Position(6, 5),1);
        arena.setMotorbikes(Arrays.asList(m));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.RIGHT, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(Frog.getLives() < 3);
    }
    @Test
    void checkCrashWithFrogMovingLeft() throws IOException {
        Motorbike m = new Motorbike(new Position(2, 5),1);
        arena.setMotorbikes(Arrays.asList(m));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.LEFT, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(Frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        Motorbike m = new Motorbike(new Position(3, 4),1);
        arena.setMotorbikes(Arrays.asList(m));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.UP, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(Frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingDown() throws IOException {
        Motorbike m = new Motorbike(new Position(3, 6),1);
        arena.setMotorbikes(Arrays.asList(m));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.DOWN, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(Frog.getLives() < 3);
    }

    @Test
    void frogDidNotCrash() throws IOException {
        Motorbike m = new Motorbike(new Position(2, 6),1);
        arena.setMotorbikes(Arrays.asList(m));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.DOWN, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(3, Frog.getLives());
    }

}
