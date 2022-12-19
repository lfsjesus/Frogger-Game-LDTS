package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.*;
import com.ldts.frogger.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OverallViewertest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        arena.setSidewalks(List.of(new Sidewalk(3, 4)));
        arena.setGrasses(List.of(new Grass(7, 8)));
        arena.setMotorbikes(List.of(new Motorbike(new Position(1, 2), 0, "#ffffff")));
        arena.setTrucks(List.of(new Truck(new Position(9, 6), 1, "#ffffff")));
        arena.setVans(Arrays.asList(new Van(new Position(10, 7), 0, "#ffffff"), new Van(new Position(10, 7), 0, "#ffffff")));
        arena.setTrees(List.of(new Tree(9, 7)));
        arena.setWaters(List.of());
        arena.setCars(Arrays.asList(new Car(new Position(4, 5), 0, "#ffffff"), new Car(new Position(5, 6), 1, "#000000")));
        arena.setFrog(new Frog(5, 8));
        arena.setCoins(List.of(new Coin(5, 8)));
        arena.setBigLogs(List.of(new BigLog(5, 8)));
        arena.setSmallLogs(List.of(new SmallLog(5, 8)));
        arena.setTrains(List.of(new Train(5, 8)));
        arena.setLavas(List.of(new Lava(5, 8)));
        arena.setRocks(List.of(new Rock(5, 8)));
    }

    @Test
    void drawFrog() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFrog(new Position(5, 8), 0, arena.getFrog().getBackgroundColor());
        Mockito.verify(gui, Mockito.times(1)).drawFrog(Mockito.any(Position.class), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(4, 5),"#ffffff",0);
        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(5, 6),"#000000", 1);
        Mockito.verify(gui, Mockito.times(2)).drawCar(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    void drawVans() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(2)).drawVan(new Position(10, 7),"#ffffff",0);
        Mockito.verify(gui, Mockito.times(2)).drawVan(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    void drawTrucks() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTruck(new Position(9, 6),"#ffffff",1);
        Mockito.verify(gui, Mockito.times(1)).drawTruck(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    void drawMotorbikes() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMotorbike(new Position(1, 2),"#ffffff",0);
        Mockito.verify(gui, Mockito.times(1)).drawMotorbike(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    void drawOtherElements() {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(6)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void drawCrossLine() {
        Arena.setLevel(5);
        viewer.drawCrossline(gui);
        Mockito.verify(gui, Mockito.times(20)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
        Arena.setLevel(1);
    }

    @Test
    void drawLives() {
        viewer.drawLives(gui);
        for (int i = 0; i < 3; i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(new Position(i+6,0), "♥", "#ff0000");
        }
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 0), "LIVES:", "#FFFFFF");
    }

    @Test
    void drawPoints() {
        viewer.drawPoints(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 0), "Score:", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 0), "0", "#FFFF00");
    }


}
