package com.ldts.frogger.viewer.menu;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.viewer.Viewer;

public class GameFinishedViewer extends Viewer<GameFinished> {

    public GameFinishedViewer(GameFinished model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {

        for(int i = 0; i < 20; i++){
            for(int j = 0; j< 20; j++){
                gui.drawBackground(new Position(i,j),"#32a852");
            }
        }

        if (getModel().getState()) gui.drawText(new Position(4, 5), "Y O U  W I N!", "#000000", "#32a852");
        else gui.drawText(new Position(3, 5), "Y O U  L O S T!", "#000000", "#32a852");

        gui.drawText(new Position(4, 7), String.format("%05d" , Arena.getPoints()) + " Points", "#023020", "#32a852");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if(getModel().isSelected(i)){
                StringBuilder s = new StringBuilder(">");
                s.append(getModel().getEntry(i));
                s.append("<");
                gui.drawText(new Position(4, 9 + i), s.toString(), "#a84c32", "#32a852");
            }
            else{
                StringBuilder s = new StringBuilder(" ");
                s.append(getModel().getEntry(i));
                s.append(" ");
                gui.drawText(new Position(4, 9 + i), s.toString(), "#FFFFFF", "#32a852");
            }
        }
    }
}
