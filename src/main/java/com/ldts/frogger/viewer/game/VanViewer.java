package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Van;

public class VanViewer implements ElementViewer<Van>{

    @Override
    public void draw(Van van, GUI gui) {
        gui.drawVan(van.getPosition(), van.getColor(), van.getDirection());
    }
}
