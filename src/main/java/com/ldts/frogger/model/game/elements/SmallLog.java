package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class SmallLog extends MoveableElement {
    public SmallLog(int x, int y) {
        super(x, y);
    }

    public SmallLog(Position position, int direction) {
        super(position, direction);
    }

}

