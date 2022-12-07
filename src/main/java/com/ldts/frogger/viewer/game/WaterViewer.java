package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Water;

public class WaterViewer implements ElementViewer<Water>{
    @Override
    public void draw(Water water, GUI gui) {
        gui.drawText(water.getPosition(),"Ļ","#1651b3","#1651b3");
    }
}
