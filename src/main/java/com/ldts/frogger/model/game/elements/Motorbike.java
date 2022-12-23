package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Motorbike extends MoveableElement {
    public Motorbike(int x, int y) {
        super(x, y);
    }

    public Motorbike(Position position, int direction, String color) {
        super(position, direction, color);
    }

    public Motorbike(Position position, int direction) {
        super(position, direction);
    }

}
