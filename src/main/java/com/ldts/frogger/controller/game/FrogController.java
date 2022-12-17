package com.ldts.frogger.controller.game;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;

public class FrogController extends GameController {
    private boolean changeDir = true;
    private long lastMovement;

    public FrogController(Arena arena) {
        super(arena);
        this.lastMovement = System.currentTimeMillis();
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

    public void checkCollisions(){
        Position frogPosition = getModel().getFrog().getPosition();
        getModel().catchCoin(frogPosition);
        if(getModel().isMoveableObstacle(frogPosition) || getModel().isNonMoveableObstacle(frogPosition)){
            getModel().getFrog().resetPosition();
            getModel().getFrog().decreaseLives();
        }
        getModel().catchCoin(frogPosition);

    }

    private void moveFrog(Position position) {
        MusicManager.getInstance().start(Sounds.FROG);

        if (getModel().isEmpty(position)) {
            getModel().getFrog().setPosition(position);

        }
    }

    public boolean reachesEndOfLevel() {
        return getModel().getFrog().getPosition().y() == 1;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if(time - lastMovement > 7000){
            getModel().getFrog().decreaseLives();
            lastMovement = time;
        }

        if (action == GUI.ACTION.UP) {

            moveFrogUp();
            if (changeDir) {
                getModel().getFrog().setDirection(1);
                changeDir = false;
            }
            else {
                getModel().getFrog().setDirection(0);
                changeDir = true;
            }
            this.lastMovement = time;
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
            this.lastMovement = time;
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
            this.lastMovement = time;
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
            this.lastMovement = time;
        }

    }
}
