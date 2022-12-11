package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Rock;

import java.io.IOException;

public class RockController extends GameController{
    private long lastMovement;
    public RockController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Rock rock : getModel().getRocks()) {
                moveRock(rock);
            }
            this.lastMovement = time;
        }
    }

    private void moveRock(Rock rock) {
        Position oldPosition = rock.getPosition();
        Position newPosition = oldPosition;

        if(rock.getDirection() == 1 && rock.getPosition().getX() > 19){
            newPosition = new Position(0, rock.getPosition().getY());
        }
        else if (rock.getDirection() == 0 && rock.getPosition().getX() < 0){
            newPosition = new Position(19, rock.getPosition().getY());
        }

        else if(rock.getDirection() == 1){
            newPosition = rock.getPosition().getRight();
        }
        else if(rock.getDirection() == 0){
            newPosition = rock.getPosition().getLeft();
        }
        if(getModel().getFrog().getPosition().equals(oldPosition)) {
            getModel().getFrog().setPosition(newPosition);
        }
        rock.setPosition(newPosition);
    }
}
