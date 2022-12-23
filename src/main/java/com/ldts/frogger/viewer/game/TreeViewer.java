package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Tree;

public class TreeViewer implements ElementViewer<Tree> {
    @Override
    public void draw(Tree tree, GUI gui) {
        gui.drawText(tree.getPosition(), tree.getTreeChar(), "#1f2d15", "#41a000");
    }
}
