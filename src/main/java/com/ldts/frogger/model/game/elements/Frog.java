package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.model.Position;

public class Frog extends Element{
    private static int lives = 3;
    private int direction = 0;
    private String backgroundColor = "#000000";

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Frog(int x, int y) {
        super(x, y);
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Frog.lives = lives;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void decreaseLives(){
        lives--;
    }
    public void resetPosition(){
        this.direction = 0;
        setPosition(new Position(9,18));
        MusicManager.getInstance().start(Sounds.CRASH);

    }
}
