package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Rock;

public class RockViewer implements ElementViewer<Rock>{
    @Override
    public void draw(Rock element, GUI gui) {
        gui.drawText(element.getPosition(),":","#4e535a","#2d2d36");
    }
}
