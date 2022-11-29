package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Frog;

public class FrogViewer implements ElementViewer<Frog> {
    @Override
    public void draw(Frog frog, GUI gui) {
        gui.drawFrog(frog.getPosition(), frog.getDirection(),frog.getBackgroundColor());
    }
}
