package com.ldts.frogger;

import com.ldts.frogger.controller.game.CarController;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

        arena = new Arena(10, 10);
        frog = new Frog(5,5);

        arena.setFrog(frog);
        arena.setCars(Arrays.asList());

        controller = new FrogController(arena);
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
        System.out.println(frog.getPosition().getY());
        assertEquals(new Position(1, 10), frog.getPosition());
    }

    @Test
    void checkCollisionWithCar() throws IOException {
        Game game = Mockito.mock(Game.class);
        CarController carController = new CarController(arena);
        Car car = new Car(3, 5);
        arena.setCars(Arrays.asList(car));
        carController.step(game, GUI.ACTION.NONE, 1000);
        assertTrue(frog.getLives() < 3);
    }

}

