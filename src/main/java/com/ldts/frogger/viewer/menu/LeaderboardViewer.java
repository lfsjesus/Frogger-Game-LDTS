package com.ldts.frogger.viewer.menu;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.menu.LeaderboardDisplay;
import com.ldts.frogger.viewer.Viewer;

public class LeaderboardViewer extends Viewer<LeaderboardDisplay> {
    public LeaderboardViewer(LeaderboardDisplay model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {

        for(int i = 0; i < 20; i++){
            for(int j = 0; j< 20; j++){
                gui.drawBackground(new Position(i,j),"#32a852");
            }
        }

        for (int i = 0; i < getModel().getLines().size(); i++) {
            gui.drawText(new Position(4, 6 + i), getModel().getEntry(i), "#FFFFFF", "#32A852");
        }

        gui.drawText(new Position(4, 3), "PTS", "#000000", "#32A852");
        gui.drawText(new Position(10, 3), "Player", "#000000", "#32A852");

    }
}
