package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.Command.Command;
import com.ldts.frogger.controller.Command.MoveLeft;
import com.ldts.frogger.controller.Command.MoveRight;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Van;

import java.io.IOException;

public class VanController extends GameController{
    private long lastMovement;

    public VanController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }
    public void checkCrash(Van van){
        if (getModel().getFrog().getPosition().equals(van.getPosition()) || getModel().getFrog().getPosition().equals(van.getPosition().getRight())) {
            getModel().getFrog().decreaseLives();
            getModel().getFrog().resetPosition();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 400) {
            for (Van van : getModel().getVans()) {
                checkCrash(van);
                if(van.getDirection() == 1){
                    moveVan(van, new MoveRight());
                }
                else {
                    moveVan(van, new MoveLeft());
                }
                checkCrash(van);
            }
            this.lastMovement = time;
        }
    }
    private void moveVan(Van van, Command command) {
        van.setPosition(command.execute(van.getPosition(),getModel())); //o command precisa da posição atual da van e de uma arena (getModel())


    }
}
