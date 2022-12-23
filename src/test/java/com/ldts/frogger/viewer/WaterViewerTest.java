package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Water;
import com.ldts.frogger.viewer.game.WaterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WaterViewerTest {
    private Water water;
    private WaterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        water = new Water(new Position(10, 10));
        viewer = new WaterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(water, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(water.getPosition(), " ", "#1651b3", "#1651b3");
    }
}
