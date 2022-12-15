package com.ldts.frogger.model.game.elements;

import com.ldts.frogger.model.Position;

public class Tree extends NonMoveableElement{
    private String treeChar;
    public Tree(int x, int y) {
        super(x, y);
    }
    public Tree(Position position, String treeChar) {
        super(position.x(),position.y());
        this.treeChar = treeChar;
    }

    public String getTreeChar() {
        return treeChar;
    }

    public void setTreeChar(String treeChar) {
        this.treeChar = treeChar;
    }
}
