package com.ldts.frogger.viewer.menu;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.menu.GameWin;
import com.ldts.frogger.viewer.Viewer;

public class GameWinViewer extends Viewer<GameWin> {

        public GameWinViewer(GameWin model) {
            super(model);
        }

    @Override
    protected void drawElements(GUI gui) {

        for(int i = 0; i < 20; i++){
            for(int j = 0; j< 20; j++){
                gui.drawBackground(new Position(i,j),"#32a852");
            }
        }

        gui.drawText(new Position(3, 5), "Y O U  W I N !", "#000000", "#32a852");
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
