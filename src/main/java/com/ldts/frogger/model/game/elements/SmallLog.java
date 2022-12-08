package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class SmallLog extends MoveableElement{
    private int direction = 0;
    public SmallLog(int x, int y) {
        super(x, y);
    }
    public SmallLog(Position position, int direction) {
        super(position.getX(), position.getY());
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
}

