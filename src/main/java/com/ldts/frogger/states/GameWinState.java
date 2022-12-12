package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.GameWinController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.model.menu.GameWin;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.GameWinViewer;

public class GameWinState extends State<GameWin> {

    public GameWinState(GameWin model) {
        super(model);
        MusicManager.getInstance().stopAll();
        MusicManager.getInstance().start(Sounds.WIN);
    }

    @Override
    protected Viewer<GameWin> getViewer() {
        return new GameWinViewer(getModel());
    }

    @Override
    protected Controller<GameWin> getController() {
        return new GameWinController(getModel());
    }
}

