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
    private List<Van> vans;
    private List<Grass> grasses;

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
    public void setFrogBackgroundColor(Position position){
        if (isSidewalk(position)){
            getFrog().setBackgroundColor("#acacac");
        }
        else if(isGrass(position)){
            getFrog().setBackgroundColor("#488f17");
        }
        else getFrog().setBackgroundColor("#000000");
    }
    public boolean isSidewalk(Position position) {
        for (Sidewalk sidewalk : sidewalks){
            if (sidewalk.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public boolean isGrass(Position position) {
        for (Grass grass : grasses){
            if (grass.getPosition().equals(position)){
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

    public List<Van> getVans() {
        return vans;
    }

    public void setVans(List<Van> vans) {
        this.vans = vans;
    }

    public List<Grass> getGrasses() {
        return grasses;
    }

    public void setGrasses(List<Grass> grasses) {
        this.grasses = grasses;
    }
}
