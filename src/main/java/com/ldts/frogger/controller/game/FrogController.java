package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;

public class FrogController extends GameController {
    private boolean changeDir = true;

    public FrogController(Arena arena) {
        super(arena);
    }

    public void moveFrogLeft() {
        moveFrog(getModel().getFrog().getPosition().getLeft());
    }

    public void moveFrogRight() {
        moveFrog(getModel().getFrog().getPosition().getRight());
    }

    public void moveFrogUp() {
        moveFrog(getModel().getFrog().getPosition().getUp());
    }

    public void moveFrogDown() {
        moveFrog(getModel().getFrog().getPosition().getDown());
    }

    public void checkCrash(){
        Position frogPosition = getModel().getFrog().getPosition();
        if(getModel().isCar(frogPosition)){
            getModel().getFrog().resetPostion();
            getModel().getFrog().decreaseLives();

        }
    }
    private void moveFrog(Position position) { //estamos a ver a nova posicao
        checkCrash();
        if (getModel().isEmpty(position) &&
                !(position.getY() < 1 || position.getY() > 19) &&
                !(position.getX() < 0 || position.getX() > 19)
        ) {
            getModel().getFrog().setPosition(position);
        }
        checkCrash();

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            //getModel().isCar(getModel().getFrog().getPosition());
            moveFrogUp();
            if (changeDir) {
                getModel().getFrog().setDirection(1);
                changeDir = false;
            }
            else {
                getModel().getFrog().setDirection(0);
                changeDir = true;
            }
        }

        else if (action == GUI.ACTION.RIGHT){
            moveFrogRight();
            if (changeDir) {
                getModel().getFrog().setDirection(2);
                changeDir = false;
            }
            else {
                getModel().getFrog().setDirection(3);
                changeDir = true;
            }
        }

        else if (action == GUI.ACTION.DOWN){
            moveFrogDown();
            if (changeDir) {
                getModel().getFrog().setDirection(4);
                changeDir = false;
            }
            else {
                getModel().getFrog().setDirection(5);
                changeDir = true;
            }
        }

        else if (action == GUI.ACTION.LEFT){
            moveFrogLeft();
            if (changeDir) {
                getModel().getFrog().setDirection(6);
                changeDir = false;
            }
            else {
                getModel().getFrog().setDirection(7);
                changeDir = true;
            }
        }

    }
}
