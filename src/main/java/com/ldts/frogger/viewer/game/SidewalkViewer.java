package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Sidewalk;

public class SidewalkViewer implements ElementViewer<Sidewalk> {

    @Override
    public void draw(Sidewalk sidewalk, GUI gui) {
        gui.drawText(sidewalk.getPosition(), " ", "#acacac", "#acacac");
    }

}
