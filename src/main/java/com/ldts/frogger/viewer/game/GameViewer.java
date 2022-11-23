package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Element;
import com.ldts.frogger.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground(new Position(5, 5),"#ffffff");
        drawLives(gui);
        drawElement(gui, getModel().getFrog(), new FrogViewer());

        //drawElements(gui, getModel().getWalls(), new TreeViewer());

        //gui.drawText(new Position(0, 0), "ENERGY: " + getModel().getFrog().getLives(), "#FFD700");

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private void drawLives(GUI gui){
        gui.drawText(new Position(0, 0), "LIVES:", "#FFFFFF");
        for(int i = 0; i < getModel().getFrog().getLives(); i++){
            gui.drawCharacter(new Position(i+6,0),'♥', "#ff0000");
        }
    }
}
