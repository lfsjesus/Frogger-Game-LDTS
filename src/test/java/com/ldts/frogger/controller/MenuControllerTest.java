package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.menu.MenuController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuControllerTest {
    private Game game;
    private Menu menu;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        menu = new Menu();
        controller = new MenuController(menu);
    }

    @Test
    void checkArrowDown() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(1));
    }

    @Test
    void checkArrowUp() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(1));
        controller.step(game, GUI.ACTION.UP, 500);
        assertEquals(controller.getModel().getEntry(controller.getModel().getCurrentEntry()), controller.getModel().getEntry(0));
    }


}
