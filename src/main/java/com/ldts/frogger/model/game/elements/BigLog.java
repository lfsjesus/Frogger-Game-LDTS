package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class BigLog extends MoveableElement{
    private int direction = 0;
    public BigLog(int x, int y) {
        super(x, y);
    }
    public BigLog(Position position, int direction) {
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
