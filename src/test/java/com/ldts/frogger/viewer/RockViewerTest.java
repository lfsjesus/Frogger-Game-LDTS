package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Rock;
import com.ldts.frogger.viewer.game.RockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RockViewerTest {
    private Rock rock;
    private RockViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        rock = new Rock(10, 10);
        viewer = new RockViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(rock, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(rock.getPosition(), "╓","#4e535a","#2d2d36");
    }
}
