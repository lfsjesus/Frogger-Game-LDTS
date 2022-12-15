package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Truck;
import com.ldts.frogger.viewer.game.TruckViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TruckViewerTest {
    private Truck truck;
    private TruckViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        truck = new Truck(new Position(10,10),1);
        viewer = new TruckViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(truck, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTruck(truck.getPosition(), truck.getColor(), truck.getDirection());
    }
}
