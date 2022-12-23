package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.LoaderArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.GameFinishedState;
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
    private final TrainController trainController;
    private final RockController rockController;

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
        this.trainController = new TrainController(arena);
        this.rockController = new RockController(arena);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            MusicManager.getInstance().stop(Sounds.SOUNDTRACK);
            Arena.setLevel(1);
            Frog.setLives(3);
            game.setState(new MenuState(new Menu()));
        } else if (frogController.reachesEndOfLevel() && Arena.getLevel() == 5) {
            MusicManager.getInstance().stop(Sounds.SOUNDTRACK);
            game.setState(new GameFinishedState(new GameFinished(true)));
        } else if (frogController.reachesEndOfLevel()) {
            Arena.setLevel(Arena.getLevel() + 1);
            game.setState(new GameState(new LoaderArenaBuilder(Arena.level).createArena()));
        } else if (Frog.getLives() == 0) {
            Arena.setLevel(1);
            game.setState(new GameFinishedState(new GameFinished(false)));
        } else {
            rockController.step(game, action, time);
            frogController.step(game, action, time);
            carController.step(game, action, time);
            truckController.step(game, action, time);
            motorbikeController.step(game, action, time);
            vanController.step(game, action, time);
            smallLogController.step(game, action, time);
            bigLogController.step(game, action, time);
            trainController.step(game, action, time);

            frogController.checkCollisions();

            getModel().setFrogBackgroundColor(getModel().getFrog().getPosition());
            if (time - arenaTime > 2000) {
                Arena.setPoints(Arena.getPoints() + 1);
                this.arenaTime = time;
            }

        }
    }
}