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
                moveCar(car, car.getPosition().getRight());
            }
            this.lastMovement = time;
        }
    }
    private void moveCar(Car car, Position position) {

        if (getModel().isEmpty(position)) {
            if(position.getX() == 20){ //se sair do lado direto voltar para a esquerda
                car.setPosition(new Position(-1,position.getY()));
            }
            else if(position.getX() == -1){
                car.setPosition(new Position(20,position.getY()));
            }
            else {
                car.setPosition(position);
            }
        }
    }

}
