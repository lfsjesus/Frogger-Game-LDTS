package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.LeaderboardController;
import com.ldts.frogger.model.menu.LeaderboardDisplay;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.LeaderboardViewer;

public class LeaderboardState extends State<LeaderboardDisplay>{

    public LeaderboardState(LeaderboardDisplay lb) {
        super(lb);
    }

    @Override
    protected Viewer<LeaderboardDisplay> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<LeaderboardDisplay> getController() {
        return new LeaderboardController(getModel());
    }
}
