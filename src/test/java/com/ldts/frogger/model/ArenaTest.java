package com.ldts.frogger.model;

import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;
    private Frog frog;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        frog = new Frog(5, 5);
        arena.setFrog(frog);
    }

    @Test
    void isEmptyTest() {
        Position position = new Position(0, 9);
        assertTrue(arena.isEmpty(position));
    }

    @Test
    void isEmptyTest2() {
        Position position = new Position(9, 9);
        assertTrue(arena.isEmpty(position));
    }

    @Test
    void isNotEmptyTest() {
        Position position = new Position(10, 9);
        assertFalse(arena.isEmpty(position));
    }

    @Test
    void isNotEmptyTest2() {
        Position position = new Position(10, 10);
        assertFalse(arena.isEmpty(position));
    }

    @Test
    void isNotEmptyTest3() {
        Tree tree = new Tree(1, 2);
        arena.setTrees(List.of(tree));
        Position position = new Position(1, 2);
        assertFalse(arena.isEmpty(position));
    }

    @Test
    void isLog1() {
        SmallLog smallLog = new SmallLog(1, 2);
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 2);
        assertTrue(arena.isLog(position));
    }

    @Test
    void isLog2() {
        BigLog bigLog = new BigLog(1, 2);
        arena.setBigLogs(List.of(bigLog));
        Position position = new Position(1, 2);
        assertTrue(arena.isLog(position));
    }

    @Test
    void isLog3() {
        SmallLog smallLog = new SmallLog(1, 2);
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 3);
        assertFalse(arena.isLog(position));
    }

    @Test
    void isLog4() {
        BigLog bigLog = new BigLog(1, 2);
        arena.setBigLogs(List.of(bigLog));
        Position position = new Position(1, 3);
        assertFalse(arena.isLog(position));
    }

    @Test
    void isLog5() {
        BigLog bigLog = new BigLog(1, 2);
        SmallLog smallLog = new SmallLog(2, 2);
        arena.setBigLogs(List.of(bigLog));
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 2);
        assertTrue(arena.isLog(position));
        Position position2 = new Position(2, 2);
        assertTrue(arena.isLog(position2));
    }

    @Test
    void isLog6() {
        Position position = new Position(1, 2);
        assertFalse(arena.isLog(position));
    }

    @Test
    void isRock() {
        Rock rock = new Rock(1, 2);
        arena.setRocks(List.of(rock));
        Position position = new Position(1, 2);
        assertTrue(arena.isRock(position));
    }

    @Test
    void isRock2() {
        Rock rock = new Rock(1, 2);
        arena.setRocks(List.of(rock));
        Position position = new Position(1, 3);
        assertFalse(arena.isRock(position));
    }

    @Test
    void canPlaceCoin() {
        Position position = new Position(1, 2);
        assertTrue(arena.canPlaceCoin(position));
    }

    @Test
    void canPlaceCoin2() {
        Water water = new Water(1, 2);
        arena.setWaters(List.of(water));
        Position position = new Position(1, 2);
        assertFalse(arena.canPlaceCoin(position));
    }

    @Test
    void canPlaceCoin3() {
        Lava lava = new Lava(1, 2);
        arena.setLavas(List.of(lava));
        Position position = new Position(1, 2);
        assertFalse(arena.canPlaceCoin(position));
    }

    @Test
    void canPlaceCoin4() {
        Rock rock = new Rock(1, 2);
        arena.setRocks(List.of(rock));
        Position position = new Position(1, 2);
        assertFalse(arena.canPlaceCoin(position));
    }

    @Test
    void canPlaceCoin5() {
        SmallLog smallLog = new SmallLog(1, 2);
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 2);
        assertFalse(arena.canPlaceCoin(position));
    }

    @Test
    void isMoveable() {
        Car car = new Car(1, 2);
        arena.setCars(List.of(car));
        Position position = new Position(1, 2);
        assertTrue(arena.isMoveableObstacle(position));
    }

    @Test
    void isMoveable2() {
        Van van = new Van(1, 2);
        arena.setVans(List.of(van));
        Position position = new Position(1, 2);
        assertTrue(arena.isMoveableObstacle(position));
    }

    @Test
    void isMoveable3() {
        Truck truck = new Truck(1, 2);
        arena.setTrucks(List.of(truck));
        Position position = new Position(1, 2);
        assertTrue(arena.isMoveableObstacle(position));
    }

    @Test
    void isMoveable4() {
        Train train = new Train(1, 2);
        arena.setTrains(List.of(train));
        Position position = new Position(1, 2);
        assertTrue(arena.isMoveableObstacle(position));
    }

    @Test
    void isMoveable5() {
        Motorbike motorbike = new Motorbike(1, 2);
        arena.setMotorbikes(List.of(motorbike));
        Position position = new Position(1, 2);
        assertTrue(arena.isMoveableObstacle(position));
    }

    @Test
    void isMoveable6() {
        Rock rock = new Rock(1, 2);
        arena.setRocks(List.of(rock));
        Position position = new Position(1, 2);
        assertFalse(arena.isMoveableObstacle(position));
    }

    @Test
    void isNonMoveable2() {
        Water water = new Water(1, 2);
        arena.setWaters(List.of(water));
        Position position = new Position(1, 2);
        assertTrue(arena.isNonMoveableObstacle(position));
    }

    @Test
    void isNonMoveable3() {
        Lava lava = new Lava(1, 2);
        arena.setLavas(List.of(lava));
        Position position = new Position(1, 2);
        assertTrue(arena.isNonMoveableObstacle(position));
    }

    @Test
    void isNonMoveable4() {
        SmallLog smallLog = new SmallLog(1, 2);
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 2);
        assertFalse(arena.isNonMoveableObstacle(position));
    }

    @Test
    void isCar() {
        Car car = new Car(1, 2);
        arena.setCars(List.of(car));
        Position position = new Position(1, 2);
        assertTrue(arena.isCar(position));
    }

    @Test
    void isNotCar() {
        Van van = new Van(1, 2);
        arena.setVans(List.of(van));
        Position position = new Position(1, 2);
        assertFalse(arena.isCar(position));
    }

    @Test
    void isVan() {
        Van van = new Van(1, 2);
        arena.setVans(List.of(van));
        Position position = new Position(1, 2);
        assertTrue(arena.isVan(position));
    }

    @Test
    void isNotVan() {
        Car car = new Car(1, 2);
        arena.setCars(List.of(car));
        Position position = new Position(1, 2);
        assertFalse(arena.isVan(position));
    }

    @Test
    void isTrain() {
        Train train = new Train(1, 2);
        arena.setTrains(List.of(train));
        Position position = new Position(1, 2);
        assertTrue(arena.isTrain(position));
    }

    @Test
    void isNotTrain() {
        Truck truck = new Truck(1, 2);
        arena.setTrucks(List.of(truck));
        Position position = new Position(1, 2);
        assertFalse(arena.isTrain(position));
    }

    @Test
    void isMotorbike() {
        Motorbike motorbike = new Motorbike(1, 2);
        arena.setMotorbikes(List.of(motorbike));
        Position position = new Position(1, 2);
        assertTrue(arena.isMotorbike(position));
    }

    @Test
    void isNotMotorbike() {
        Truck truck = new Truck(1, 2);
        arena.setTrucks(List.of(truck));
        Position position = new Position(1, 2);
        assertFalse(arena.isMotorbike(position));
    }

    @Test
    void isTruck() {
        Truck truck = new Truck(1, 2);
        arena.setTrucks(List.of(truck));
        Position position = new Position(1, 2);
        assertTrue(arena.isTruck(position));
    }

    @Test
    void isNotTruck() {
        Train train = new Train(1, 2);
        arena.setTrains(List.of(train));
        Position position = new Position(1, 2);
        assertFalse(arena.isTruck(position));
    }

    @Test
    void setBackColor() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#acacac");
    }

    @Test
    void setBackColor1() {
        Grass grass = new Grass(1, 2);
        arena.setGrasses(List.of(grass));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#41a000");
    }

    @Test
    void setBackColor2() {
        SmallLog smallLog = new SmallLog(1, 2);
        arena.setSmallLogs(List.of(smallLog));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#624219");
    }

    @Test
    void setBackColor3() {
        Rock rock = new Rock(1, 2);
        arena.setRocks(List.of(rock));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#4e535a");
    }

    @Test
    void setBackColor4() {
        Water water = new Water(1, 2);
        arena.setWaters(List.of(water));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#1651b3");
    }

    @Test
    void setBackColor5() {
        Lava lava = new Lava(1, 2);
        arena.setLavas(List.of(lava));
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#ff2500");
    }

    @Test
    void defaultBackgroundColor() {
        Position position = new Position(1, 2);
        frog.setPosition(position);
        arena.setFrogBackgroundColor(position);
        assertEquals(frog.getBackgroundColor(), "#000000");
    }

    @Test
    void coinBC() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        Coin coin = new Coin(1, 2);
        arena.setCoins(List.of(coin));
        assertEquals(arena.getCoinBackgroundColor(position), "#acacac");
    }

    @Test
    void coinBC1() {
        Grass grass = new Grass(1, 2);
        arena.setGrasses(List.of(grass));
        Position position = new Position(1, 2);
        Coin coin = new Coin(1, 2);
        arena.setCoins(List.of(coin));
        assertEquals(arena.getCoinBackgroundColor(position), "#41a000");
    }

    @Test
    void coinDefault() {
        Position position = new Position(1, 2);
        Coin coin = new Coin(1, 2);
        arena.setCoins(List.of(coin));
        assertEquals(arena.getCoinBackgroundColor(position), "#000000");
    }

    @Test
    void isSidewalk() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertTrue(arena.isSidewalk(position));
    }

    @Test
    void isNotSidewalk() {
        Grass grass = new Grass(1, 2);
        arena.setGrasses(List.of(grass));
        Position position = new Position(1, 2);
        assertFalse(arena.isSidewalk(position));
    }

    @Test
    void isGrass() {
        Grass grass = new Grass(1, 2);
        arena.setGrasses(List.of(grass));
        Position position = new Position(1, 2);
        assertTrue(arena.isGrass(position));
    }

    @Test
    void isNotGrass() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertFalse(arena.isGrass(position));
    }

    @Test
    void isWater() {
        Water water = new Water(1, 2);
        arena.setWaters(List.of(water));
        Position position = new Position(1, 2);
        assertTrue(arena.isWater(position));
    }

    @Test
    void isNotWater() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertFalse(arena.isWater(position));
    }

    @Test
    void isLava() {
        Lava lava = new Lava(1, 2);
        arena.setLavas(List.of(lava));
        Position position = new Position(1, 2);
        assertTrue(arena.isLava(position));
    }

    @Test
    void isNotLava() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertFalse(arena.isLava(position));
    }

    @Test
    void isTree() {
        Tree tree = new Tree(1, 2);
        arena.setTrees(List.of(tree));
        Position position = new Position(1, 2);
        assertTrue(arena.isTree(position));
    }

    @Test
    void isNotTree() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertFalse(arena.isTree(position));
    }

    @Test
    void isCoin() {
        Coin coin = new Coin(1, 2);
        arena.setCoins(List.of(coin));
        Position position = new Position(1, 2);
        assertTrue(arena.isCoin(position));
    }

    @Test
    void isNotCoin() {
        Sidewalk sidewalk = new Sidewalk(1, 2);
        arena.setSidewalks(List.of(sidewalk));
        Position position = new Position(1, 2);
        assertFalse(arena.isCoin(position));
    }
}
