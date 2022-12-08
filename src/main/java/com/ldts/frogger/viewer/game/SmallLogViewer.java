package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.SmallLog;

public class SmallLogViewer implements ElementViewer<SmallLog> {
    @Override
    public void draw(SmallLog smallLog, GUI gui) {
        gui.drawText(smallLog.getPosition(), "ĻĻ", "#523715", "#624219");
    }
}
