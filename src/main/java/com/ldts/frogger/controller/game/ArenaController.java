package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final FrogController frogController;
    private final CarController carController;

    public ArenaController(Arena arena) {
        super(arena);
        this.frogController = new FrogController(arena);
        this.carController = new CarController(arena);

    }


    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getFrog().getLives() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            frogController.step(game, action, time);
            carController.step(game,action,time);

        }
    }
}