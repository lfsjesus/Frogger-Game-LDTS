package com.ldts.frogger.model.game.arena;


import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setCars(createCars());
        arena.setSidewalks(createSidewalks());
        arena.setTrucks(createTrucks());
        arena.setMotorbikes(createMotorbikes());
        arena.setVans(createVans());
        arena.setGrasses(createGrasses());
        arena.setTrees(createTrees());
        return arena;
    }

    protected abstract List<Car> createCars();
    protected abstract List<Truck> createTrucks();
    protected abstract List<Van> createVans();
    protected abstract List<Motorbike> createMotorbikes();

    protected abstract List<Sidewalk> createSidewalks();

    protected abstract List<Grass> createGrasses();

    protected abstract List<Tree> createTrees();


    protected abstract int getWidth();

    protected abstract int getHeight();


}
