package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.GameFinishedController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.GameFinishedViewer;

public class GameFinishedState extends State<GameFinished> {

    public GameFinishedState(GameFinished model) {
        super(model);
        MusicManager.getInstance().stopAll();
        if (getModel().getState()) MusicManager.getInstance().start(Sounds.WIN);
        else MusicManager.getInstance().start(Sounds.GAMEOVER);
    }

    @Override
    protected Viewer<GameFinished> getViewer() {
        return new GameFinishedViewer(getModel());
    }

    @Override
    protected Controller<GameFinished> getController() {
        return new GameFinishedController(getModel());
    }
}
