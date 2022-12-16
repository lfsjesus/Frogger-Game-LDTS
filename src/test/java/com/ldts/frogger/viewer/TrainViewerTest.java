package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Train;
import com.ldts.frogger.viewer.game.TrainViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TrainViewerTest {
    private Train train;
    private TrainViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        train = new Train(new Position(10,10),1);
        viewer = new TrainViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(train, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTrain(train.getPosition(), train.getColor(), train.getDirection());
    }
}
