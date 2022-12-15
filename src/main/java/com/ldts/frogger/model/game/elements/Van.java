package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Van extends MoveableElement{
    public Van(int x, int y) {
        super(x, y);
    }

    public Van(Position position, int direction, String color) {
        super(position, direction, color);
    }
    public Van(Position position, int direction) {
        super(position, direction);
    }

}
