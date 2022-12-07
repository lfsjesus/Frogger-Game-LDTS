package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Grass;

public class GrassViewer implements ElementViewer<Grass>{
    @Override
    public void draw(Grass grass, GUI gui) {
        gui.drawText(grass.getPosition(), " ","#488f17","#488f17");
    }
}
