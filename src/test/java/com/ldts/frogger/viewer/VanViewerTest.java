package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Van;
import com.ldts.frogger.viewer.game.VanViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VanViewerTest {
    private Van van;
    private VanViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        van = new Van(new Position(10,10),1);
        viewer = new VanViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(van, gui);
        Mockito.verify(gui, Mockito.times(1)).drawVan(van.getPosition(), van.getColor(), van.getDirection());
    }
}
