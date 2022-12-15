package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Motorbike;
import com.ldts.frogger.model.game.elements.Van;
import com.ldts.frogger.viewer.game.MotorbikeViewer;
import com.ldts.frogger.viewer.game.VanViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MotorbikeViewerTest {
    private Motorbike motorbike;
    private MotorbikeViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        motorbike = new Motorbike(new Position(10,10),1);
        viewer = new MotorbikeViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(motorbike, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMotorbike(motorbike.getPosition(), motorbike.getColor(), motorbike.getDirection());
    }
}
