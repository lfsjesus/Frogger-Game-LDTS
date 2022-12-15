package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Lava extends NonMoveableElement{
    public Lava(int x, int y) {
        super(x, y);
    }
    public Lava(Position position) {
        super(position.x(),position.y());
    }
}
