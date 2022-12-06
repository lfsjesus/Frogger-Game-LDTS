package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Frog frog;
    private List<Car> cars;
    private List<Sidewalk> sidewalks;
    private List<Truck> trucks;
    private List<Motorbike> motorbikes;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Frog getFrog() {
        return frog;
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }
    public boolean isEmpty(Position position) {

        return true;
    }
    public boolean isCar(Position position) {
        for (Car car : cars){
            if (car.getPosition().equals(position) || car.getPosition().getRight().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isTruck(Position position) {
        for (Truck truck : trucks){
            if (truck.getPosition().equals(position) || truck.getPosition().getRight().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isSidewalk(Position position) {
        for (Sidewalk sidewalk : sidewalks){
            if (sidewalk.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public List<Sidewalk> getSidewalks() {
        return this.sidewalks;
    }

    public void setSidewalks(List<Sidewalk> sidewalks) {
        this.sidewalks = sidewalks;
    }
    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Motorbike> getMotorbikes() {
        return motorbikes;
    }

    public void setMotorbikes(List<Motorbike> motorbikes) {
        this.motorbikes = motorbikes;
    }
}
