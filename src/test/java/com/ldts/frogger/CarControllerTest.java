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

import static org.junit.jupiter.api.Assertions.*;

public class CarControllerTest {
    private CarController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach

    void setUp() {
        arena = new Arena(10,10);
        frog = new Frog(5,5);
        arena.setFrog(frog);

        arena.setCars(Arrays.asList());
        controller = new CarController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveCars() throws IOException {
        Car car = new Car(5,5);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 1000);
        assertNotEquals(new Position(5,5), car.getPosition());
    }

    @Test
    void moveCarAgainstWall() throws IOException {
        Car car = new Car(9,5);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(new Position(-1,5), car.getPosition());
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        Car car = new Car(4, 5);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        Car car = new Car(6, 5);
        arena.setCars(Arrays.asList(car));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.RIGHT, 2000);
        assertTrue(frog.getLives() < 3);
    }
    @Test
    void checkCrashWithFrogMovingLeft() throws IOException {
        Car car = new Car(2, 5);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.LEFT, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        Car car = new Car(3, 4);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.UP, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingDown() throws IOException {
        Car car = new Car(3, 6);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.DOWN, 2000);
        assertTrue(frog.getLives() < 3);
    }

}
