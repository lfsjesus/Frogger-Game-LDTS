package com.ldts.frogger.viewer.menu;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "FROGGER", "#32a852");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if(getModel().isSelected(i)){
                StringBuilder s = new StringBuilder(">");
                s.append(getModel().getEntry(i));
                s.append("<");
                gui.drawText(new Position(5, 9 + i), s.toString(), "#a84c32");
            }
            else{
                StringBuilder s = new StringBuilder(" ");
                s.append(getModel().getEntry(i));
                s.append(" ");
                gui.drawText(new Position(5, 9 + i), s.toString(), "#FFFFFF");
            }

        }
    }
}
