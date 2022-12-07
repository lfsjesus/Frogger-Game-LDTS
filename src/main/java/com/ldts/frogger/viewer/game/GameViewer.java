package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Element;
import com.ldts.frogger.model.game.elements.Water;
import com.ldts.frogger.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawLives(gui);
        drawPoints(gui);
        drawElements(gui,getModel().getGrasses(),new GrassViewer());
        drawElements(gui,getModel().getWaters(),new WaterViewer());
        drawElements(gui,getModel().getSidewalks(),new SidewalkViewer());
        drawElements(gui,getModel().getTrees(),new TreeViewer());
        drawElements(gui,getModel().getCoins(),new CoinViewer());
        drawElement(gui, getModel().getFrog(), new FrogViewer());
        drawElements(gui, getModel().getCars(), new CarViewer());
        drawElements(gui, getModel().getTrucks(), new TruckViewer());
        drawElements(gui, getModel().getMotorbikes(), new MotorbikeViewer());
        drawElements(gui, getModel().getVans(), new VanViewer());
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
            gui.drawText(new Position(i+6,0),"♥", "#ff0000");
        }
    }

    private void drawPoints(GUI gui) {
        gui.drawText(new Position(getModel().getWidth() - 10, 0), "Score:", "#FFFFFF");
        gui.drawText(new Position(getModel().getWidth() - 4, 0), String.valueOf(Arena.getPoints()), "#FFFF00");

    }
}
