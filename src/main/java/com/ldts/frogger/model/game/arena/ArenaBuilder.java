package com.ldts.frogger.model.game.arena;


import com.ldts.frogger.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setFrog(createFrog());
        arena.setCars(createCars());
        arena.setSidewalks(createSidewalks());
        arena.setBigLogs(createBigLogs());
        arena.setSmallLogs(createSmallLogs());
        arena.setRocks(createRocks());
        arena.setTrucks(createTrucks());
        arena.setTrains(createTrains());
        arena.setMotorbikes(createMotorbikes());
        arena.setVans(createVans());
        arena.setGrasses(createGrasses());
        arena.setTrees(createTrees());
        arena.setWaters(createWaters());
        arena.setLavas(createLavas());
        arena.setCoins(arena.createCoins());

        return arena;
    }

    protected abstract Frog createFrog();
    protected abstract List<Car> createCars();
    protected abstract List<Truck> createTrucks();
    protected abstract List<Van> createVans();
    protected abstract List<Motorbike> createMotorbikes();

    protected abstract List<Sidewalk> createSidewalks();

    protected abstract List<Grass> createGrasses();

    protected abstract List<Tree> createTrees();
    protected abstract List<Water> createWaters();
    protected abstract List<Lava> createLavas();
    protected abstract List<BigLog> createBigLogs();
    protected abstract List<SmallLog> createSmallLogs();

    protected abstract List<Train> createTrains();
    protected abstract List<Rock> createRocks();

    protected abstract int getWidth();
    protected abstract int getHeight();



}
