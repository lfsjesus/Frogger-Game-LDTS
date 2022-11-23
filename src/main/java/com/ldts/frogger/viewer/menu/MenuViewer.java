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

        drawMenuBackground(gui);
        drawMenuBorder(gui);
        drawMenuText(gui);

    }

    private void drawMenuBackground(GUI gui) {
        for(int i = 0; i < 20; i++){
            for(int j = 0; j< 20; j++){
                gui.drawBackground(new Position(i,j),"#32a852");
            }
        }
    }

    private void drawMenuBorder(GUI gui) {
        //border
        //horizontal
        gui.drawText(new Position(3,2),"┌","#47ed74", "#000000");
        for(int i = 4; i < 15 ; i++){
            gui.drawText(new Position(i,2),"─","#47ed74", "#000000");
        }
        gui.drawText(new Position(15,2),"┐","#47ed74", "#000000");

        //vertical
        for(int i = 3; i<13; i++){
            gui.drawText(new Position(3,i),"│","#47ed74", "#000000");
        }
        gui.drawText(new Position(3,13),"└","#47ed74", "#000000");

        gui.drawText(new Position(6, 5), "FROGGER", "#47ed74");

        //horizontal
        for(int i = 4; i < 15 ; i++){
            gui.drawText(new Position(i,13),"─","#47ed74", "#000000");
        }
        gui.drawText(new Position(15,13),"┘","#47ed74", "#000000");

        //vertical
        for(int i = 3; i<13; i++){
            gui.drawText(new Position(15,i),"│","#47ed74", "#000000");
        }
    }

    public void drawMenuText(GUI gui){
        //print menu text
        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if(getModel().isSelected(i)){
                StringBuilder s = new StringBuilder(">");
                s.append(getModel().getEntry(i));
                s.append("<");
                gui.drawText(new Position(6, 9 + i), s.toString(), "#a84c32");
            }
            else{
                StringBuilder s = new StringBuilder(" ");
                s.append(getModel().getEntry(i));
                s.append(" ");
                gui.drawText(new Position(6, 9 + i), s.toString(), "#FFFFFF");
            }
        }
    }
}
