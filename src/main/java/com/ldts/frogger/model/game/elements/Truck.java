package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Truck extends MoveableElement{

    public Truck(int x, int y) {
        super(x, y);
    }

    public Truck(Position position, int direction, String color) {
        super(position, direction, color);
    }

    public Truck(Position position, int direction) {
        super(position, direction);
    }

}
