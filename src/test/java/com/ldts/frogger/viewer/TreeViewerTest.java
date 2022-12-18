package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Tree;
import com.ldts.frogger.viewer.game.TreeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TreeViewerTest {
    private Tree tree;
    private TreeViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        tree = new Tree(new Position(10, 10), "a");
        viewer = new TreeViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(tree, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(tree.getPosition(), "a", "#1f2d15", "#41a000");
    }
}
