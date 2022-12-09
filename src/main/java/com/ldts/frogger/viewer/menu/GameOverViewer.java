package com.ldts.frogger.viewer.menu;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.menu.GameOver;
import com.ldts.frogger.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        for (int i = 0; i < getModel().getEntries().size(); i++) {
            gui.drawText(new Position(4, 6 + i), getModel().getEntry(i), "#FFFFFF", "#32A852");
        }
    }
}
