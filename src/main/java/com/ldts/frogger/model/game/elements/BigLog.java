package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class BigLog extends MoveableElement{
    public BigLog(int x, int y) {
        super(x, y);
    }
    public BigLog(Position position, int direction) {
        super(position, direction);
    }

}
