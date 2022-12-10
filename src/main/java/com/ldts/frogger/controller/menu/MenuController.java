package com.ldts.frogger.controller.menu;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.LoaderArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.LeaderboardState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()){
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    MusicManager.getInstance().start(Sounds.SOUNDTRACK);
                    Arena.setPoints(0);
                    Frog.setLives(3);
                }
                if (getModel().isSelectedLeaderboard()) game.setState(new LeaderboardState(new Leaderboard()));
        }
    }
}
