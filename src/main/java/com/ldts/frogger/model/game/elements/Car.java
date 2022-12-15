package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Car extends MoveableElement{
    public Car(int x, int y) {
        super(x, y);
    }

    public Car(Position position, int direction, String color) {
        super(position, direction, color);
    }

    public Car(Position position, int direction) {
        super(position, direction);
    }

}
