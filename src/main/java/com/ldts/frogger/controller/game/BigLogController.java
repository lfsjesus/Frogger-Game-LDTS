package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.BigLog;
import com.ldts.frogger.model.game.elements.Water;

import java.io.IOException;

public class BigLogController extends GameController{
    private long lastMovement;
    public BigLogController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 400) {
            for (BigLog bigLog : getModel().getBigLogs()) {
                if(bigLog.getDirection() == 1){
                    moveBigLog(bigLog, new MoveRight());
                }
                else {
                    moveBigLog(bigLog, new MoveLeft());
                }
            }
            this.lastMovement = time;
        }

    }
    private void moveBigLog(BigLog bigLog, Command command) {
        Position oldPosition = bigLog.getPosition();
        Position newPosition = command.execute(bigLog.getPosition(),getModel()); //o command precisa da posição atual do log e de uma arena (getModel())

        for(Water water : getModel().getWaters()){
            if(water.getPosition().equals(oldPosition) || water.getPosition().equals(oldPosition.getRight()) || water.getPosition().equals(oldPosition.getRight().getRight())){
                getModel().getWaters().remove(water);
                break;
            }
        }

        //getModel().getWaters().removeIf(water -> water.getPosition().equals(oldPosition));
        //getModel().getWaters().removeIf(water -> water.getPosition().equals(oldPosition.getRight()));

        bigLog.setPosition(newPosition);

        getModel().getWaters().add(new Water(oldPosition));
        getModel().getWaters().add(new Water(oldPosition.getRight()));

    }

}
