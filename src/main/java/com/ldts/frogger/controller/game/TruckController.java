package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Truck;

import java.io.IOException;

public class TruckController extends GameController {
    private long lastMovement;

    public TruckController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    public void checkCrash(Truck truck) {
        Frog frog = getModel().getFrog();
        if (frog.getPosition().equals(truck.getPosition()) || frog.getPosition().equals(truck.getPosition().getRight())) {
            frog.decreaseLives();
            frog.resetPosition();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 400) {
            for (Truck truck : getModel().getTrucks()) {
                checkCrash(truck);
                if (truck.getDirection() == 1) {
                    moveTruck(truck, new MoveRight());
                } else {
                    moveTruck(truck, new MoveLeft());
                }
                checkCrash(truck);
            }
            this.lastMovement = time;
        }
    }

    private void moveTruck(Truck truck, Command command) {
        truck.setPosition(command.execute(truck.getPosition(), getModel()));

    }
}
