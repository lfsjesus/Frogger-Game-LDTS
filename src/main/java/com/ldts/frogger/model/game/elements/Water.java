package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Water extends NonMoveableElement {
    public Water(int x, int y) {
        super(x, y);
    }

    public Water(Position position) {
        super(position.x(), position.y());
    }


}

