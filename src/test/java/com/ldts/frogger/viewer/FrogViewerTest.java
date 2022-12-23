package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.viewer.game.FrogViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FrogViewerTest {
    private Frog frog;
    private FrogViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        frog = new Frog(10, 10);
        viewer = new FrogViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(frog, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFrog(frog.getPosition(), 0, frog.getBackgroundColor());
    }
}
