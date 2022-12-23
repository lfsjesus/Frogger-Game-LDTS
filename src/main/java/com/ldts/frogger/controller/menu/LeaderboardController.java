package com.ldts.frogger.controller.menu;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.MenuState;

import java.io.IOException;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard lb) {
        super(lb);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
    }
}
