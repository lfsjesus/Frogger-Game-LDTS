package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Car extends MoveableElement{
    private int direction = 0;
    private String color;
    public Car(int x, int y) {
        super(x, y);
    }

    public Car(Position position, int direction, String color) {
        super(position.getX(), position.getY());
        this.direction = direction;
        this.color = color;
    }

    public Car(Position position, int direction) {
        super(position.getX(), position.getY());

        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getColor() {
        return this.color;
    }
}
