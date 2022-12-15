package com.ldts.frogger.model.menu;

import java.util.Arrays;

public class GameFinished extends Menu {
    private boolean state;
    public GameFinished(boolean state) {
        setEntries(Arrays.asList("TRY AGAIN", "ADD RECORD", "EXIT"));
        this.state = state;
    }

    public boolean getState() {
        return state;
    }
}
