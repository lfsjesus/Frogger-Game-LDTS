package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
        MusicManager.getInstance().stop(Sounds.GAMEOVER);
        if (!MusicManager.getInstance().isPlaying(Sounds.SOUNDTRACK))
            MusicManager.getInstance().start(Sounds.SOUNDTRACK);
    }

    // For testing purposes
    public GameState(Arena model, Controller<Arena> controller, Viewer<Arena> viewer) {
        super(model, controller, viewer);
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
