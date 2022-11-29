package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;
import com.sun.source.tree.Tree;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Frog frog;
    private List<Car> cars;
    private List<Sidewalk> sidewalks;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

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
}
