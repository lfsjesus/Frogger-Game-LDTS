package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Frog extends Element{
    private int lives = 3;
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void decreaseLives(){
        this.lives--;
    }
    public void resetPostion(){
        this.direction = 0;
        setPosition(new Position(8,18));
    }
}
