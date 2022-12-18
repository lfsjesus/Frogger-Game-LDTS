package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.viewer.menu.GameFinishedViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameFinishedViewerTest {
    private GameFinished gameFinished;
    private GameFinishedViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawGameFinishedElements1() {
        gameFinished = new GameFinished(true);
        viewer = new GameFinishedViewer(gameFinished);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(400)).drawBackground(Mockito.any(), Mockito.anyString());
        Mockito.verify(gui, Mockito.times(5)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 5), "Y O U  W I N!", "#000000", "#32a852");
    }

    @Test
    void drawGameFinishedElements2() {
        gameFinished = new GameFinished(false);
        viewer = new GameFinishedViewer(gameFinished);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(400)).drawBackground(Mockito.any(), Mockito.anyString());
        Mockito.verify(gui, Mockito.times(5)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3, 5), "Y O U  L O S T!", "#000000", "#32a852");
    }

}
