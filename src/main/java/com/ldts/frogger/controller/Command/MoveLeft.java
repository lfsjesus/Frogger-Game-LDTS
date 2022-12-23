package com.ldts.frogger.controller.Command;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;

public class MoveLeft extends Command {

    @Override
    public Position execute(Position position, Arena arena) {
        if (position.x() == -1) {
            return new Position(arena.getWidth() - 1, position.y());
        }
        return position.getLeft();
    }
}
