package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.BigLog;

import java.io.IOException;

public class BigLogController extends GameController{
    private long lastMovement;
    public BigLogController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 600) {
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
        Position newPosition = command.execute(oldPosition,getModel()); //o command precisa da posição atual do log e de uma arena (getModel())

        if(getModel().getFrog().getPosition().equals(oldPosition)){ //se estou na ponta do tronco
            getModel().getFrog().setPosition(newPosition);
        }
        else if(getModel().getFrog().getPosition().equals(oldPosition.getRight())){ //se estou a meio do tronco
            getModel().getFrog().setPosition(newPosition.getRight());
        }
        else if(getModel().getFrog().getPosition().equals(oldPosition.getRight().getRight())){// se estou na outra ponta do tronco
            getModel().getFrog().setPosition(newPosition.getRight().getRight());
        }
        bigLog.setPosition(newPosition);
    }

}
