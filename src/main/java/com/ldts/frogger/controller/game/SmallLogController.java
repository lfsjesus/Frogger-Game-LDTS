package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.SmallLog;

import java.io.IOException;

public class SmallLogController extends GameController {
    private long lastMovement;

    public SmallLogController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 300) {
            for (SmallLog smallLog : getModel().getSmallLogs()) {
                if (smallLog.getDirection() == 1) {
                    moveSmallLog(smallLog, new MoveRight());
                } else {
                    moveSmallLog(smallLog, new MoveLeft());
                }
            }
            this.lastMovement = time;
        }
    }

    private void moveSmallLog(SmallLog smallLog, Command command) {
        Position oldPosition = smallLog.getPosition();
        Position newPosition = command.execute(oldPosition, getModel());
        Frog frog = getModel().getFrog();

        if (frog.getPosition().equals(oldPosition)) {
            frog.setPosition(newPosition);
        } else if (frog.getPosition().equals(oldPosition.getRight())) {
            frog.setPosition(newPosition.getRight());
        }

        smallLog.setPosition(newPosition);
    }
}
