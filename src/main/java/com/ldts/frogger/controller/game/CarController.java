package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;

import java.io.IOException;

public class CarController extends GameController {
    private long lastMovement;

    public CarController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Car car : getModel().getCars())
                moveCar(car, car.getPosition().getRight());
            this.lastMovement = time;
        }
    }
    private void moveCar(Car car, Position position) {
        if (getModel().isEmpty(position)) {
            if(position.getX() == 20){
                car.setPosition(new Position(0,position.getY()));
            }
            else {
                car.setPosition(position);
            }

            if (getModel().getFrog().getPosition().equals(position))
                getModel().getFrog().decreaseLives();
        }
    }
}
