package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Train;

import java.io.IOException;

public class TrainController extends GameController{
    private long lastMovement;

    public TrainController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }
    public void checkCrash(Train train){
        if (getModel().getFrog().getPosition().greaterOrEqual(train.getPosition()) && getModel().getFrog().getPosition().lessOrEqual(new Position(15,0))){
            getModel().getFrog().decreaseLives();
            getModel().getFrog().resetPosition();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(time - lastMovement > 100){
            for(Train train : getModel().getTrains()){
                checkCrash(train);
                moveTrain(train);
                checkCrash(train);
            }
            this.lastMovement = time;
        }
    }
    private void moveTrain(Train train) {
        if(train.getDirection() == 1 && train.getPosition().getX() > 20){
            train.setPosition(new Position(-30,train.getPosition().getY()));
        }
        else if(train.getDirection() == 0 && train.getPosition().getX() < 0){
            train.setPosition(new Position(30,train.getPosition().getY()));
        }
        else if(train.getDirection() == 1){
            train.setPosition(train.getPosition().getRight());
        }
        else if(train.getDirection() == 0){
            train.setPosition(train.getPosition().getLeft());
        }
    }
}

