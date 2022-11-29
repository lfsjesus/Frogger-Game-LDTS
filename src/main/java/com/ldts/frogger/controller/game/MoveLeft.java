package com.ldts.frogger.controller.game;

import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;

public class MoveLeft extends Command{

    @Override
    public Position execute(Position position, Arena arena) {
        if (position.getX() < 0){
            return new Position(arena.getWidth()-1,position.getY());
        }
        return position.getLeft();
    }
}
