package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Train;

public class TrainViewer implements ElementViewer<Train>{

    @Override
    public void draw(Train train, GUI gui) {
        gui.drawTrain(train.getPosition(), train.getColor(), train.getDirection());
    }
}
