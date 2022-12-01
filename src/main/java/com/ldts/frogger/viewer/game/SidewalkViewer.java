package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Element;
import com.ldts.frogger.model.game.elements.Sidewalk;
import com.ldts.frogger.viewer.Viewer;

public class SidewalkViewer implements ElementViewer<Sidewalk> {

    @Override
    public void draw(Sidewalk sidewalk, GUI gui) {
        gui.drawText(sidewalk.getPosition(), " ","#488f17","#acacac");
    }

}
