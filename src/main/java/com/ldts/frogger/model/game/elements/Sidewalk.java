package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Sidewalk extends NonMoveableElement {
    public Sidewalk(int x, int y) {
        super(x, y);
    }

    public Sidewalk(Position position) {
        super(position.x(), position.y());
    }
}
