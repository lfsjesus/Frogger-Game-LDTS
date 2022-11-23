package com.ldts.frogger.controller.game;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
