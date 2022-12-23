package com.ldts.frogger.controller.Command;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;


public class MoveRight extends Command {

    @Override
    public Position execute(Position position, Arena arena) {
        if (position.x() == arena.getWidth() - 1) {
            return new Position(-1, position.y());
        }
        return position.getRight();
    }
}
