package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    public static int level = 1;
    private final int width;
    private final int height;
    private static int points = 0;
    private Frog frog;
    private List<Car> cars;
    private List<Sidewalk> sidewalks;
    private List<Truck> trucks;
    private List<Motorbike> motorbikes;
    private List<Van> vans;
    private List<Grass> grasses;
    private List<Tree> trees;
    private List<Water> waters;
    private List<Coin> coins;
    private List<BigLog> bigLogs;
    private List<SmallLog> smallLogs;
    private List<Train> trains;
    private List<Lava> lavas;
    private List<Rock> rocks;

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
        return !(position.getY() < 1 || position.getY() > height - 1) && !(position.getX() < 0 || position.getX() > width - 1) && !isTree(position);
    }
    public boolean isLog(Position position){
        for (BigLog bigLog : bigLogs) {
            if (bigLog.getPosition().equals(position) || bigLog.getPosition().getRight().equals(position) || bigLog.getPosition().getRight().getRight().equals(position)) {
                return true;
            }
        }
        for (SmallLog smallLog : smallLogs) {
            if (smallLog.getPosition().equals(position) || smallLog.getPosition().getRight().equals(position)) {
                return true;
            }
        }
        return false;
    }
    public boolean isRock(Position position){
        for (Rock rock : rocks) {
            if (rock.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
    public boolean canPlaceCoin(Position position){
        return isEmpty(position) && !isWater(position) && !isLog(position) && !isLava(position) && !isRock(position);
    }
    public boolean isMoveableObstacle(Position position) {
        return isCar(position) || isTruck(position) || isVan(position) || isMotorbike(position) || isTrain(position);
    }
    public boolean isNonMoveableObstacle(Position frogPosition) {
        return (isLava(frogPosition)  && !isRock(frogPosition)) || (isWater(frogPosition) && !isLog(frogPosition));
    }
    public boolean isCar(Position position) {
        for (Car car : cars){
            if (car.getPosition().equals(position) || car.getPosition().getRight().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isTrain(Position position){
        for (Train train : trains){
            if(position.greaterOrEqual(train.getPosition()) && position.lessOrEqual(train.getPosition().add(new Position(15,0)))){
                return true;
            }
        }
        return false;
    }
    public boolean isVan(Position position){
        for (Van van : vans){
            if (van.getPosition().equals(position) || van.getPosition().getRight().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isMotorbike(Position position){
        for (Motorbike motorbike : motorbikes){
            if (motorbike.getPosition().equals(position) || motorbike.getPosition().getRight().equals(position)){
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
            getFrog().setBackgroundColor("#41a000");
        }
        else if(isLog(position)){
            getFrog().setBackgroundColor("#624219");
        }
        else if(isRock(position)){
            getFrog().setBackgroundColor("#4e535a");
        }
        else if(isWater(position)){
            getFrog().setBackgroundColor("#1651b3");
        }
        else if(isLava(position)){
            getFrog().setBackgroundColor("#ff2500");
        }
        else getFrog().setBackgroundColor("#000000");
    }
    public String getCoinBackgroundColor(Position position){
        if (isSidewalk(position)){
            return "#acacac";
        }
        else if(isGrass(position)){
            return "#41a000";
        }
        else return "#000000";
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
    public boolean isWater(Position frogPosition) {
        for (Water water : waters){
            if (water.getPosition().equals(frogPosition)){
                return true;
            }
        }
        return false;
    }

    public boolean isLava(Position position){
        for (Lava lava : lavas){
            if (lava.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isTree(Position position) {
        for (Tree tree : trees){
            if (tree.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isCoin(Position position) {
        for (Coin coin : coins){
            if (coin.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    public void catchCoin(Position position){
        for (Coin coin : coins){
            if (coin.getPosition().equals(position)){
                coins.remove(coin);
                points+=5;
                MusicManager.getInstance().start(Sounds.COIN);
                break;
            }
        }
    }
    public List<Coin> createCoins(){
        List<Coin> coins = new ArrayList<>();

        do{
            //create random position for coin
            int x = (int)(Math.random()*getWidth());
            int y = (int)(Math.random()*getHeight());
            //check if the position is valid
            Position position = new Position(x,y);
            if (canPlaceCoin(position)){
                coins.add(new Coin(position, getCoinBackgroundColor(position)));
            }

        } while(coins.size() < 10);

        return coins;
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

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Water> getWaters() {
        return waters;
    }

    public void setWaters(List<Water> waters) {
        this.waters = waters;
    }

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        Arena.points = points;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<BigLog> getBigLogs() {return bigLogs;}

    public void setBigLogs(List<BigLog> bigLogs) {this.bigLogs = bigLogs;}

    public List<SmallLog> getSmallLogs() {return smallLogs;}

    public void setSmallLogs(List<SmallLog> smallLogs) {this.smallLogs = smallLogs;}

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Arena.level = level;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Lava> getLavas() {
        return lavas;
    }

    public void setLavas(List<Lava> lavas) {
        this.lavas = lavas;
    }

    public List<Rock> getRocks() {
        return rocks;
    }

    public void setRocks(List<Rock> rocks) {
        this.rocks = rocks;
    }
}
