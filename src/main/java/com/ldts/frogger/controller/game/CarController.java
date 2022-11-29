package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.game.elements.Frog;

import java.io.IOException;

public class CarController extends GameController {
    private long lastMovement;

    public CarController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }
    public void checkCrash(Car car){
        if (getModel().getFrog().getPosition().equals(car.getPosition()) || getModel().getFrog().getPosition().equals(car.getPosition().getRight())) {
            getModel().getFrog().decreaseLives();
            getModel().getFrog().resetPostion();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 200) {
            for (Car car : getModel().getCars()) {
                checkCrash(car);
                if(car.getDirection() == 1){
                    moveCar(car, new MoveRight());
                }
                else {
                    moveCar(car, new MoveLeft());
                }
                checkCrash(car);
            }
            this.lastMovement = time;
        }
    }
    private void moveCar(Car car, Command command) {
        car.setPosition(command.execute(car.getPosition(),getModel())); //o command precisa da posição atual do carro e de uma arena (getModel())


    }

}
