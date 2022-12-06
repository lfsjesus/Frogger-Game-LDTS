package com.ldts.frogger.model.game.arena;


import com.ldts.frogger.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setFrog(createFrog());
        arena.setCars(createCars());
        arena.setSidewalks(createSidewalks());
        arena.setTrucks(createTrucks());
        arena.setMotorbikes(createMotorbikes());
        arena.setVans(createVans());
        arena.setGrasses(createGrasses());
        return arena;
    }

    protected abstract List<Car> createCars();
    protected abstract List<Truck> createTrucks();
    protected abstract List<Van> createVans();

    protected abstract List<Sidewalk> createSidewalks();

    protected abstract List<Grass> createGrasses();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Frog createFrog();
    protected abstract List<Motorbike> createMotorbikes();

}
