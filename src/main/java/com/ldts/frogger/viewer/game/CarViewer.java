package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Car;

public class CarViewer implements ElementViewer<Car> {
    @Override
    public void draw(Car car, GUI gui) {
        gui.drawCar(car.getPosition(), car.getColor(), car.getDirection());
    }
}
