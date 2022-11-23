package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
