package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Truck;

public class TruckViewer implements ElementViewer<Truck> {
    @Override
    public void draw(Truck truck, GUI gui) {
        gui.drawTruck(truck.getPosition(), truck.getColor(), truck.getDirection());

    }
}
