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

        //drawElements(gui, getModel().getWalls(), new TreeViewer());
        //drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        gui.drawBackground(new Position(5, 5),"#ffffff");
        drawElement(gui, getModel().getFrog(), new FrogViewer());


        /*
        gui.drawText(new Position(0, 0), "ENERGY: " + getModel().getHero().getEnergy(), "#FFD700");
        */
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
