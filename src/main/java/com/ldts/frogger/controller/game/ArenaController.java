package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.LoaderArenaBuilder;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private long arenaTime;
    private final FrogController frogController;
    private final CarController carController;
    private final TruckController truckController;
    private final VanController vanController;
    private final MotorbikeController motorbikeController;
    private final SmallLogController smallLogController;
    private final BigLogController bigLogController;

    public ArenaController(Arena arena) {
        super(arena);
        this.arenaTime = 0;
        this.frogController = new FrogController(arena);
        this.carController = new CarController(arena);
        this.truckController = new TruckController(arena);
        this.motorbikeController = new MotorbikeController(arena);
        this.vanController = new VanController(arena);
        this.smallLogController = new SmallLogController(arena);
        this.bigLogController = new BigLogController(arena);

    }


    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getFrog().getLives() == 0)
            game.setState(new MenuState(new Menu()));
        else if(frogController.reachesEndOfLevel()){
            Arena.setLevel(Arena.getLevel()+1);
            game.setState(new GameState(new LoaderArenaBuilder(Arena.level).createArena()));
        }

        else {
            frogController.step(game, action, time);
            carController.step(game,action,time);
            truckController.step(game,action,time);
            motorbikeController.step(game,action,time);
            vanController.step(game, action,time);
            smallLogController.step(game,action,time);
            bigLogController.step(game,action,time);


            frogController.checkCollisions();
            //change frog background color after each step
            getModel().setFrogBackgroundColor(getModel().getFrog().getPosition());
            if (time - arenaTime > 2000) {
                Arena.setPoints(Arena.getPoints() + 1);
                this.arenaTime = time;
            }

        }
    }
}