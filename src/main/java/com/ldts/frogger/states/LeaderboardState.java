package com.ldts.frogger.states;

import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.menu.LeaderboardController;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.viewer.Viewer;
import com.ldts.frogger.viewer.menu.LeaderboardViewer;

public class LeaderboardState extends State<Leaderboard>{

    public LeaderboardState(Leaderboard lb) {
        super(lb);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
