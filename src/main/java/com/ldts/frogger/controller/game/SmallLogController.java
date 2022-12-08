package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.SmallLog;
import com.ldts.frogger.model.game.elements.Water;

import java.io.IOException;

public class SmallLogController extends GameController{
    private long lastMovement;

    public SmallLogController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 200) {
            for (SmallLog smallLog : getModel().getSmallLogs()) {
                if(smallLog.getDirection() == 1){
                    moveSmallLog(smallLog, new MoveRight());
                }
                else {
                    moveSmallLog(smallLog, new MoveLeft());
                }
            }
            this.lastMovement = time;
        }
    }
    private void moveSmallLog(SmallLog smallLog, Command command) {
        Position oldPosition = smallLog.getPosition();
        Position newPosition = command.execute(smallLog.getPosition(),getModel()); //o command precisa da posição atual do log e de uma arena (getModel())

        for(Water water : getModel().getWaters()){
            if(water.getPosition().equals(oldPosition) || water.getPosition().equals(oldPosition.getRight())){
                getModel().getWaters().remove(water);
                break;
            }
        }


        //getModel().getWaters().removeIf(water -> water.getPosition().equals(oldPosition));
        //getModel().getWaters().removeIf(water -> water.getPosition().equals(oldPosition.getRight()));

        smallLog.setPosition(newPosition);

        getModel().getWaters().add(new Water(oldPosition));
        getModel().getWaters().add(new Water(oldPosition.getRight()));

    }


}
