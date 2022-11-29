package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;


public abstract class Command {

    public abstract Position execute(Position position, Arena arena);
}
