package com.ldts.frogger.model.game.elements;

public class Frog extends Element{
    private int lives = 3;
    private int direction = 0;

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
}
