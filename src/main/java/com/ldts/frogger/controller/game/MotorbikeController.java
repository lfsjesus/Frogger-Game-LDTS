package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Motorbike;

import java.io.IOException;



public class MotorbikeController extends GameController {
    private long lastMovement;

    public MotorbikeController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    public void checkCrash(Motorbike motorbike) {
        if (getModel().getFrog().getPosition().equals(motorbike.getPosition()) || getModel().getFrog().getPosition().equals(motorbike.getPosition().getRight())) {
            getModel().getFrog().decreaseLives();
            getModel().getFrog().resetPosition();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 200) {
            for (Motorbike motorbike : getModel().getMotorbikes()) {
                checkCrash(motorbike);
                if (motorbike.getDirection() == 1) {
                    moveMotorbike(motorbike, new MoveRight());
                } else {
                    moveMotorbike(motorbike, new MoveLeft());
                }
                checkCrash(motorbike);
            }
            this.lastMovement = time;
        }
    }
    private void moveMotorbike(Motorbike motorbike, Command command) {
        motorbike.setPosition(command.execute(motorbike.getPosition(), getModel())); //o command precisa da posição atual da motorbike e de uma arena (getModel())
    }
}
