package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfCars;
    private final int numberOfTrucks;
    private final int numberOfGrasses;
    private final int numberOfMotorbikes;
    private final int numberOfVans;
    private final int numberOfTrains;
    private final int numberOfTrees;
    private final int numberOfSideWalks;
    private final int numberOfCoins;
    private final int numberOfWaters;
    private final int numberOfLavas;
    private final int numberOfSmallLogs;
    private final int numberOfBigLogs;
    private final int numberOfRocks;



    public RandomArenaBuilder(int width, int height, int numberOfCars, int numberOfTrucks, int numberOfMotorbikes, int numberOfVans, int numberOfTrains, int numberOfGrasses, int numberOfTrees, int numberOfSideWalks, int numberOfWaters, int numberOfCoins, int numberOfSmallLogs, int numberOfBigLogs, int numberOfLavas, int numberOfRocks) {
        this.rng = new Random();
        this.numberOfGrasses = numberOfGrasses;
        this.numberOfTrees = numberOfTrees;
        this.numberOfSideWalks = numberOfSideWalks;
        this.width = width;
        this.height = height;
        this.numberOfCars = numberOfCars;
        this.numberOfTrucks = numberOfTrucks;
        this.numberOfMotorbikes = numberOfMotorbikes;
        this.numberOfVans = numberOfVans;
        this.numberOfWaters = numberOfWaters;
        this.numberOfCoins = numberOfCoins;
        this.numberOfSmallLogs = numberOfSmallLogs;
        this.numberOfBigLogs = numberOfBigLogs;
        this.numberOfTrains = numberOfTrains;
        this.numberOfLavas = numberOfLavas;
        this.numberOfRocks = numberOfRocks;
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
    protected List<Van> createVans() {
        List<Van> vans = new ArrayList<>();

        while (vans.size() < numberOfVans)
            vans.add(new Van(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return vans;
    }
    @Override
    protected List<Train> createTrains(){
        List<Train> trains = new ArrayList<>();

        while (trains.size() < numberOfTrains)
            trains.add(new Train(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return trains;
    }
    @Override
    protected List<Motorbike> createMotorbikes() {
        List<Motorbike> motorbikes = new ArrayList<>();

        while (motorbikes.size() < numberOfMotorbikes)
            motorbikes.add(new Motorbike(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return motorbikes;
    }
    @Override
    protected List<Sidewalk> createSidewalks() {
        List<Sidewalk> sidewalks = new ArrayList<>();

        while (sidewalks.size() < numberOfSideWalks)
            sidewalks.add(new Sidewalk(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return sidewalks;
    }

    @Override
    protected List<Grass> createGrasses() {
        List<Grass> grasses = new ArrayList<>();

        while (grasses.size() < numberOfGrasses)
            grasses.add(new Grass(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return grasses;
    }

    @Override
    protected List<Tree> createTrees() {
        List<Tree> trees = new ArrayList<>();

        while (trees.size() < numberOfTrees)
            trees.add(new Tree(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return trees;
    }

    @Override
    protected List<Water> createWaters() {
        List<Water> waters = new ArrayList<>();

        while (waters.size() < numberOfWaters)
            waters.add(new Water(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return waters;
    }
    @Override
    protected List<Lava> createLavas(){
        List<Lava> lavas = new ArrayList<>();

        while (lavas.size() < numberOfLavas)
            lavas.add(new Lava(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return lavas;
    }

    @Override
    protected List<BigLog> createBigLogs() {
        List<BigLog> bigLogs = new ArrayList<>();

        while (bigLogs.size() < numberOfBigLogs)
            bigLogs.add(new BigLog(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return bigLogs;
    }

    @Override
    protected List<SmallLog> createSmallLogs() {
        List<SmallLog> smallLogs = new ArrayList<>();

        while (smallLogs.size() < numberOfSmallLogs)
            smallLogs.add(new SmallLog(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return smallLogs;
    }

    @Override
    protected List<Rock> createRocks() {
        List<Rock> rocks = new ArrayList<>();

        while (rocks.size() < numberOfRocks)
            rocks.add(new Rock(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return rocks;
    }

    @Override
    protected Frog createFrog() {
        return new Frog(width / 2 - 1, height -2);
    }


}
