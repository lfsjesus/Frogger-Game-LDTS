package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.CarController;
import com.ldts.frogger.controller.game.FrogController;
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

public class FrogControllerTest {
    private FrogController controller;
    private Frog frog;
    private Arena arena;

    @BeforeEach
    void setUp() {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            arena = new Arena(10, 10);
            frog = new Frog(5, 5);
            arena.setSidewalks(Arrays.asList(new Sidewalk(3, 4)));
            arena.setGrasses(Arrays.asList(new Grass(7, 8)));
            arena.setMotorbikes(Arrays.asList(new Motorbike(8, 7)));
            arena.setTrucks(Arrays.asList(new Truck(8, 7)));
            arena.setVans(Arrays.asList(new Van(8, 7)));
            arena.setTrees(Arrays.asList());
            arena.setFrog(frog);
            arena.setCars(Arrays.asList());
            arena.setWaters(Arrays.asList());

            controller = new FrogController(arena);
        }
    }

    @Test
    void moveFrogRight() {
        controller.moveFrogRight();
        assertEquals(new Position(6,5), frog.getPosition());
    }

    @Test
    void moveFrogLeft() {
        controller.moveFrogLeft();
        assertEquals(new Position(4,5), frog.getPosition());
    }

    @Test
    void moveFrogUp() {
        controller.moveFrogUp();
        assertEquals(new Position(5,4), frog.getPosition());
    }
    @Test
    void moveFrogDown() {
        controller.moveFrogDown();
        assertEquals(new Position(5,6), frog.getPosition());
    }

    @Test
    void moveFrogRightAgainstWall() {
        frog.setPosition(new Position(9, 10));
        controller.moveFrogRight();
        assertEquals(new Position(9, 10), frog.getPosition());
    }

    @Test
    void moveFrogLeftAgainstWall() {
        frog.setPosition(new Position(0, 10));
        controller.moveFrogLeft();
        assertEquals(new Position(0, 10), frog.getPosition());
    }

    @Test
    void moveFrogUpAgainstWall() {
        frog.setPosition(new Position(1, 1));
        controller.moveFrogUp();
        assertEquals(new Position(1, 1), frog.getPosition());
    }

    @Test
    void moveFrogDownAgainstWall() {
        frog.setPosition(new Position(1, 10));
        controller.moveFrogDown();
        System.out.println(frog.getPosition().y());
        assertEquals(new Position(1, 10), frog.getPosition());
    }

    @Test
    void checkCollisionWithCar() throws IOException {
        Game game = Mockito.mock(Game.class);
        CarController carController = new CarController(arena);
        Car car = new Car(new Position(3,5),1);
        arena.setCars(Arrays.asList(car));
        carController.step(game, GUI.ACTION.NONE, 1000);
        assertTrue(frog.getLives() < 3);
    }

}

