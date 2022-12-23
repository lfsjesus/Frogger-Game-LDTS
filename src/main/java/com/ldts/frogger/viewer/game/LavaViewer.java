package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Lava;

public class LavaViewer implements ElementViewer<Lava> {

    @Override
    public void draw(Lava element, GUI gui) {
        gui.drawText(element.getPosition(), "o", "#ff6600", "#ff2500");
    }
}
