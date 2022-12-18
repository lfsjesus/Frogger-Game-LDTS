package com.ldts.frogger.controller.menu;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Controller;
import com.ldts.frogger.controller.InputDialog;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.LoaderArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.model.menu.Leaderboard;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.MenuState;


import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameFinishedController extends Controller<GameFinished> {
    public GameFinishedController(GameFinished model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT -> game.setState(new MenuState(new Menu()));
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                else if (getModel().isSelectedStart()) {
                    Arena.setPoints(0);
                    Frog.setLives(3);
                    game.setState(new GameState(new LoaderArenaBuilder(Arena.getLevel()).createArena()));
                } else {
                    try {
                        String name = new InputDialog().getString().toUpperCase(Locale.ROOT);
                        Leaderboard leaderboard = new Leaderboard();
                        leaderboard.addRecord(Arena.getPoints(), name);
                        game.setState(new MenuState(new Menu()));
                    } catch (NullPointerException e) {
                        Logger logger = Logger.getLogger(GameFinishedController.class.getName());
                        logger.log(Level.SEVERE, e.getMessage(), e);
                    }
                    Arena.setPoints(0);
                    Frog.setLives(3);
                }
            }
            default -> {}
        }
    }
}
