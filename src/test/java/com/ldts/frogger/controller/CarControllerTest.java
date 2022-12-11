package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.CarController;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.*;
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
        arena.setSidewalks(Arrays.asList(new Sidewalk(3,4)));
        arena.setGrasses(Arrays.asList(new Grass(7,8)));
        arena.setMotorbikes(Arrays.asList(new Motorbike(8, 7)));
        arena.setTrucks(Arrays.asList(new Truck(8, 7)));
        arena.setVans(Arrays.asList(new Van(8, 7)));
        arena.setTrees(Arrays.asList(new Tree(9, 7)));
        arena.setWaters(Arrays.asList());
        controller = new CarController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveCars() throws IOException {
        Car car = new Car(new Position(5,5),1);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 1000);
        assertNotEquals(new Position(5,5), car.getPosition());
    }

    @Test
    void moveCarAgainstWall() throws IOException {
        Car car = new Car(new Position(9,5),1);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        System.out.println(car.getPosition().getX());
        assertEquals(new Position(-1,5), car.getPosition());
    }

    @Test
    void checkCrashWithFrogNotMoving() throws IOException {
        Car car = new Car(new Position(4, 5),1);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingRight() throws IOException {
        Car car = new Car(new Position(6, 5),1);
        arena.setCars(Arrays.asList(car));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.RIGHT, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }
    @Test
    void checkCrashWithFrogMovingLeft() throws IOException {
        Car car = new Car(new Position(2, 5),1);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.LEFT, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingUp() throws IOException {
        Car car = new Car(new Position(3, 4),1);
        arena.setCars(Arrays.asList(car));
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.UP, 2000);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertTrue(frog.getLives() < 3);
    }

    @Test
    void checkCrashWithFrogMovingDown() throws IOException {
        Car car = new Car(new Position(3, 6),1);
        arena.setCars(Arrays.asList(car));
        controller.step(game, GUI.ACTION.NONE, 2000);
        FrogController frogController = new FrogController(arena);
        frogController.step(game, GUI.ACTION.DOWN, 2000);
        assertTrue(frog.getLives() < 3);
    }

}
