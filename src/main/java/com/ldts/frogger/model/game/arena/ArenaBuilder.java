package com.ldts.frogger.model.game.arena;


import com.ldts.frogger.model.game.elements.Frog;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setFrog(createFrog());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();


    protected abstract Frog createFrog();
}
