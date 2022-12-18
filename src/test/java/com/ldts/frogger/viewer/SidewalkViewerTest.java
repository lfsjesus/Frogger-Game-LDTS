package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Sidewalk;
import com.ldts.frogger.viewer.game.SidewalkViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SidewalkViewerTest {
    private Sidewalk sidewalk;
    private SidewalkViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        sidewalk = new Sidewalk(10, 10);
        viewer = new SidewalkViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(sidewalk, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(sidewalk.getPosition(), " ","#acacac","#acacac");
    }
}
