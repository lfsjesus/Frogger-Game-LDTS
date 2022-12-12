package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.GameOverController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.model.menu.GameOver;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {

    public GameOverState(GameOver model) {
        super(model);
        MusicManager.getInstance().stopAll();
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
