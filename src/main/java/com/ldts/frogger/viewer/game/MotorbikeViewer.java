package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Motorbike;

public class MotorbikeViewer implements ElementViewer<Motorbike> {
    @Override
    public void draw(Motorbike motorbike, GUI gui) {
        gui.drawMotorbike(motorbike.getPosition(), motorbike.getColor(), motorbike.getDirection());
    }
}
