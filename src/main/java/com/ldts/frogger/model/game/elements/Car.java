package com.ldts.frogger.model.game.elements;

public class Car extends MoveableElement{
    private String type = "car";
    private int direction = 0;
    public Car(int x, int y) {
        super(x, y);
    }

    public String getType() {
        return type;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
