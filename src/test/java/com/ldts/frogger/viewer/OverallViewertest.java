package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class OverallViewertest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setCars(Arrays.asList(new Car(4, 5), new Car(5, 6)));
        arena.setFrog(new Frog(5, 8));
    }

    @Test
    void drawFrog() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFrog(new Position(5, 8), 0);
        Mockito.verify(gui, Mockito.times(1)).drawFrog(Mockito.any(Position.class), Mockito.anyInt());
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(4, 5),"#ffffff",1);
        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(5, 6),"#ffffff", 1);
        Mockito.verify(gui, Mockito.times(2)).drawCar(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyInt());
    }


}
