package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.viewer.game.CarViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class CarViewerTest {
    private Car car;
    private CarViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        car = new Car(new Position(10, 10), 1);
        viewer = new CarViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() throws IOException {
        viewer.draw(car, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCar(car.getPosition(), car.getColor(), car.getDirection());
    }
}
