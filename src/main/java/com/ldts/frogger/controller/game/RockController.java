package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
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
            boolean frog_moved = false;
            Frog frog = getModel().getFrog();
            for (Rock rock : getModel().getRocks()) {
                Position oldPosition = rock.getPosition();
                moveRock(rock);
                if(frog.getPosition().equals(oldPosition) && !frog_moved){
                    frog.setPosition(rock.getPosition());
                    frog_moved = true;
                }
            }
            this.lastMovement = time;
        }
    }

    private void moveRock(Rock rock) {
        Position oldPosition = rock.getPosition();
        Position newPosition = oldPosition;

        if (rock.getDirection() == 1) {
            if (rock.getPosition().x() > getModel().getWidth())
                newPosition = new Position(0, rock.getPosition().y());
            else
               newPosition = rock.getPosition().getRight();
        }
        else if (rock.getDirection() == 0) {
            if (rock.getPosition().x() < 0)
                newPosition = new Position(getModel().getWidth() - 1, rock.getPosition().y());
            else
                newPosition = rock.getPosition().getLeft();
        }
        rock.setPosition(newPosition);
    }
}
