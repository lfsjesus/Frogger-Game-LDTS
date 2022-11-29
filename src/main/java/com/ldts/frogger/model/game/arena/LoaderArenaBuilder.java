package com.ldts.frogger.model.game.arena;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Sidewalk;

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
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F') return new Frog(x, y);
        }
        return null;
    }
}