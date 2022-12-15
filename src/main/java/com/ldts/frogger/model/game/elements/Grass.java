package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Grass extends NonMoveableElement{
    public Grass(int x, int y) {
        super(x, y);
    }
    public Grass(Position position){
        super(position.getX(), position.getY());
    }
}
