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
    private final TruckController truckController;
    private final VanController vanController;
    private final MotorbikeController motorbikeController;

    public ArenaController(Arena arena) {
        super(arena);
        this.frogController = new FrogController(arena);
        this.carController = new CarController(arena);
        this.truckController = new TruckController(arena);
        this.motorbikeController = new MotorbikeController(arena);
        this.vanController = new VanController(arena);

    }


    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getFrog().getLives() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            frogController.step(game, action, time);
            carController.step(game,action,time);
            truckController.step(game,action,time);
            motorbikeController.step(game,action,time);
            vanController.step(game, action,time);

            //change frog background color after each step
            getModel().setFrogBackgroundColor(getModel().getFrog().getPosition());

        }
    }
}