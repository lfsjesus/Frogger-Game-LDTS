package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Lava;
import com.ldts.frogger.viewer.game.LavaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LavaViewerTest {
    private Lava lava;
    private LavaViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        lava = new Lava(new Position(10, 10));
        viewer = new LavaViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(lava, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(lava.getPosition(), "Ļ","#ff6600","#ff2500");
    }
}
