package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Train;

import java.io.IOException;

public class TrainController extends GameController{
    private long lastMovement;

    public TrainController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }
    public void checkCrash(Train train){
        Frog frog = getModel().getFrog();
        if (frog.getPosition().greaterOrEqual(train.getPosition()) && frog.getPosition().lessOrEqual(train.getPosition().add(new Position(15,0)))){
            frog.decreaseLives();
            frog.resetPosition();
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
        if (train.getDirection() == 1) {
            if(train.getPosition().x() == getModel().getWidth() - 1){
                train.setPosition(new Position(-30,train.getPosition().y()));
            }
            else train.setPosition(train.getPosition().getRight());
        }
        else if (train.getDirection() == 0) {
            if(train.getPosition().x() == -17){
                train.setPosition(new Position(getModel().getWidth() + 10,train.getPosition().y()));
            }
            else train.setPosition(train.getPosition().getLeft());
        }
    }
}

