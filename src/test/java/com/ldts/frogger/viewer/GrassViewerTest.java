package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Grass;
import com.ldts.frogger.viewer.game.GrassViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GrassViewerTest {
    private Grass grass;
    private GrassViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        grass = new Grass(10, 10);
        viewer = new GrassViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(grass, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(grass.getPosition(), " ", "#488f17", "#41a000");
    }
}
