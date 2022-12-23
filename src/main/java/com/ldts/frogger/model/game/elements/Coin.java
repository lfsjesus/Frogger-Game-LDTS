package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Coin extends NonMoveableElement {
    private String backGroundColor;

    public Coin(int x, int y) {
        super(x, y);
    }

    public Coin(Position position, String backGroundColor) {
        super(position.x(), position.y());
        this.backGroundColor = backGroundColor;
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

}
