package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Car;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.viewer.game.CarViewer;
import com.ldts.frogger.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MenuViewerTest {
    private Menu menu;
    private MenuViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        viewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMenuBorder() {
        viewer.drawMenuBorder(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3,2),"┌","#47ed74", "#000000");
    }

    @Test
    void drawMenuText() {
        viewer.drawMenuText(gui);
        Mockito.verify(gui, Mockito.times(3)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void drawMenuBackground() {
        viewer.drawMenuBackground(gui);
        Mockito.verify(gui, Mockito.times(400)).drawBackground(Mockito.any(), Mockito.anyString());
    }

    @Test
    void drawMenuBorder2() {
        viewer.drawMenuBorder(gui);
        Mockito.verify(gui, Mockito.times(46)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void drawElements() {
        viewer = Mockito.spy(viewer);
        viewer.drawElements(gui);
        Mockito.verify(viewer, Mockito.times(1)).drawMenuBackground(gui);
        Mockito.verify(viewer, Mockito.times(1)).drawMenuBorder(gui);
        Mockito.verify(viewer, Mockito.times(1)).drawMenuText(gui);
    }

}
