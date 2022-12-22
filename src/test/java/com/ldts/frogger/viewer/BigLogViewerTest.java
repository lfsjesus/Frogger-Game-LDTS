package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.BigLog;
import com.ldts.frogger.viewer.game.BigLogViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BigLogViewerTest {
    private BigLog bigLog;
    private BigLogViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bigLog = new BigLog(10, 10);
        viewer = new BigLogViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bigLog, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(bigLog.getPosition(), "ooo", "#523715", "#624219");
    }

}
