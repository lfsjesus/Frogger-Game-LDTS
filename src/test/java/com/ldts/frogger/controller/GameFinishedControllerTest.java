package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.menu.GameFinishedController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.menu.GameFinished;
import com.ldts.frogger.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameFinishedControllerTest {
    private Game game;
    private GameFinished menu1;

    private GameFinished menu2;
    private GameFinishedController controller1;
    private GameFinishedController controller2;

    @BeforeEach
    void setUp() {
        game = new Game(Mockito.mock(LanternaGUI.class));
        menu1 = new GameFinished(true);
        menu2 = new GameFinished(false);
        controller1 = new GameFinishedController(menu1);
        controller2 = new GameFinishedController(menu2);
    }

    @Test
    void checkArrowDown() throws IOException {
        controller1.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller1.getModel().getEntry(controller1.getModel().getCurrentEntry()), controller1.getModel().getEntry(1));
        controller2.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller2.getModel().getEntry(controller2.getModel().getCurrentEntry()), controller2.getModel().getEntry(1));
    }

    @Test
    void checkArrowUp() throws IOException {
        controller1.step(game, GUI.ACTION.DOWN, 500);
        controller2.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(controller1.getModel().getEntry(controller1.getModel().getCurrentEntry()), controller1.getModel().getEntry(1));
        assertEquals(controller2.getModel().getEntry(controller2.getModel().getCurrentEntry()), controller2.getModel().getEntry(1));
        controller1.step(game, GUI.ACTION.UP, 500);
        controller2.step(game, GUI.ACTION.UP, 500);
        assertEquals(controller1.getModel().getEntry(controller1.getModel().getCurrentEntry()), controller1.getModel().getEntry(0));
        assertEquals(controller2.getModel().getEntry(controller2.getModel().getCurrentEntry()), controller2.getModel().getEntry(0));
    }

    @Test
    void checkIsSelectedExit() throws IOException {
        controller1.step(game, GUI.ACTION.DOWN, 500);
        controller1.step(game, GUI.ACTION.DOWN, 500);
        controller1.step(game, GUI.ACTION.SELECT, 500);
        assertNull(game.getState());
        controller2.step(game, GUI.ACTION.DOWN, 500);
        controller2.step(game, GUI.ACTION.DOWN, 500);
        controller2.step(game, GUI.ACTION.SELECT, 500);
        assertNull(game.getState());
    }

    @Test
    void checkGameStart() throws IOException {
        controller1.step(game, GUI.ACTION.SELECT, 500);
        assertTrue(game.getState() instanceof GameState);
        assertEquals(3, Frog.getLives());
        assertEquals(0, Arena.getPoints());

    }


}
