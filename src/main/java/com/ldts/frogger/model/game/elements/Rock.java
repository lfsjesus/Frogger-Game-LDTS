package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Rock extends MoveableElement{
    public Rock(int x, int y) {
        super(x, y);
    }
    public Rock(Position position, int direction) {
        super(position, direction);
    }

}
