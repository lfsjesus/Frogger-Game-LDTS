package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;
import com.ldts.frogger.model.game.elements.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfCars;
    private final int numberOfTrucks;
    private final int numberOfSideWalks = 5;

    public RandomArenaBuilder(int width, int height, int numberOfCars, int numberOfTrucks) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfCars = numberOfCars;
        this.numberOfTrucks = numberOfTrucks;
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
    protected List<Truck> createTrucks() {
        List<Truck> trucks = new ArrayList<>();

        while (trucks.size() < numberOfTrucks)
            trucks.add(new Truck(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return trucks;
    }

    @Override
    protected List<Sidewalk> createSidewalks() {
        List<Sidewalk> sidewalks = new ArrayList<>();

        while (sidewalks.size() < numberOfSideWalks)
            sidewalks.add(new Sidewalk(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return sidewalks;
    }

    @Override
    protected Frog createFrog() {
        return new Frog(width / 2, height / 2);
    }
}
