package com.ldts.frogger.viewer.game;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
