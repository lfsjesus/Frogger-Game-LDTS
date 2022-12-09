package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        List<String> colors = Arrays.asList("#ff8a00","#ffffff","#4fb72e","#c8b510","#2b8aba","#ca01fb","#0909c9","#fe0003");
        int index = 0;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                index = (int)(Math.random()*colors.size());
                if (line.charAt(x) == 'D') cars.add(new Car(new Position(x,y),1,colors.get(index)));
                else if (line.charAt(x) == 'E') cars.add(new Car(new Position(x,y),0,colors.get(index)));
            }
        }

        return cars;
    }

    @Override
    protected List<Truck> createTrucks() {
        List<Truck> trucks = new ArrayList<>();
        List<String> colors = Arrays.asList("#ff8a00","#ffffff","#4fb72e","#c8b510","#2b8aba","#ca01fb","#0909c9","#fe0003");
        int index = 0;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                index = (int)(Math.random()*colors.size());
                if (line.charAt(x) == 'T') trucks.add(new Truck(new Position(x,y),1,colors.get(index)));
                else if (line.charAt(x) == 'Y') trucks.add(new Truck(new Position(x,y),0,colors.get(index)));
            }
        }

        return trucks;
    }
    @Override
    protected List<Motorbike> createMotorbikes() {
        List<Motorbike> motorbikes = new ArrayList<>();
        List<String> colors = Arrays.asList("#ff8a00","#ffffff","#4fb72e","#c8b510","#2b8aba","#ca01fb","#0909c9","#fe0003");
        int index = 0;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                index = (int)(Math.random()*colors.size());
                if (line.charAt(x) == 'M') motorbikes.add(new Motorbike(new Position(x,y),1,colors.get(index)));
                else if (line.charAt(x) == 'N') motorbikes.add(new Motorbike(new Position(x,y),0,colors.get(index)));
            }
        }

        return motorbikes;
    }
    @Override
    protected List<Van> createVans() {
        List<Van> vans = new ArrayList<>();
        List<String> colors = Arrays.asList("#ff8a00","#ffffff","#4fb72e","#c8b510","#2b8aba","#ca01fb","#0909c9","#fe0003");
        int index = 0;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                index = (int)(Math.random()*colors.size());
                if (line.charAt(x) == 'B') vans.add(new Van(new Position(x,y),1,colors.get(index)));
                else if (line.charAt(x) == 'V') vans.add(new Van(new Position(x,y),0,colors.get(index)));
            }
        }

        return vans;
    }

    @Override
    protected List<Sidewalk> createSidewalks() {
        List<Sidewalk> sidewalks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'S') sidewalks.add(new Sidewalk(new Position(x,y)));

            }
        }

        return sidewalks;
    }
    @Override
    protected List<Grass> createGrasses() {
        List<Grass> grasses = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'G') grasses.add(new Grass(new Position(x,y)));

            }
        }

        return grasses;
    }
    @Override
    protected List<Tree> createTrees() {
        List<Tree> trees = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'P') {
                    int random = (int) (Math.random() * 2);
                    if(random == 0) {
                        trees.add(new Tree(new Position(x, y), "đ"));
                    }
                    else {
                        trees.add(new Tree(new Position(x, y), "Đ"));
                    }
                }
            }
        }
        return trees;
    }
    @Override
    protected List<Water> createWaters() {
        List<Water> waters = new ArrayList<>();
        Position initialPosition = new Position(0,0);
        Position finalPosition = new Position(0,0);
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'W') {
                    initialPosition = new Position(x,y);
                }
                else if(line.charAt(x) == 'F') {
                    finalPosition = new Position(x,y);
                    break;
                }
            }
        }

         for(int y = initialPosition.getY(); y <= finalPosition.getY(); y++){
             for(int x = initialPosition.getX(); x <= finalPosition.getX(); x++){
                 waters.add(new Water(new Position(x,y)));
             }
         }

        return waters;
    }
    @Override
    protected List<BigLog> createBigLogs(){
        List<BigLog> bigLogs = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'L') {
                    bigLogs.add(new BigLog(new Position(x, y), 1));
                }
                else if (line.charAt(x) == 'O') {
                    bigLogs.add(new BigLog(new Position(x, y), 0));
                }
            }
        }
        return bigLogs;
    }
    protected List<SmallLog> createSmallLogs(){
        List<SmallLog> smallLogs = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'J') {
                    smallLogs.add(new SmallLog(new Position(x, y), 1));
                }
                else if (line.charAt(x) == 'K') {
                    smallLogs.add(new SmallLog(new Position(x, y), 0));
                }
            }
        }
        return smallLogs;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected Frog createFrog() {
        return new Frog(9,8);
        //return new Frog (getWidth()/2 - 1, getHeight() - 2);
    }

}