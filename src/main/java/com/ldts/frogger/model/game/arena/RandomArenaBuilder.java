package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfCars;

    public RandomArenaBuilder(int width, int height, int numberOfCars) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfCars = numberOfCars;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        while (cars.size() < numberOfCars)
            cars.add(new Car(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return cars;
    }

    @Override
    protected List<Sidewalk> createSidewalks() {

        return null;
    }

    @Override
    protected Frog createFrog() {
        return new Frog(width / 2, height / 2);
    }
}
