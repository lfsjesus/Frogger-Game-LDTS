package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class MoveableElement extends Element{
    private int direction;
    private String color;
    public MoveableElement(int x, int y) {
        super(x, y);
    }
    public MoveableElement(Position position, int direction, String color) {
        super(position.x(), position.y());
        this.direction = direction;
        this.color = color;
    }

    public MoveableElement(Position position, int direction) {
        super(position.x(), position.y());
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getColor() {
        return color;
    }

}
