package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.SmallLog;
import com.ldts.frogger.viewer.game.SmallLogViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SmallLogViewerTest {
    private SmallLog smallLog;
    private SmallLogViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        smallLog = new SmallLog(10, 10);
        viewer = new SmallLogViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(smallLog, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(smallLog.getPosition(), "ĻĻ", "#523715", "#624219");
    }
}
