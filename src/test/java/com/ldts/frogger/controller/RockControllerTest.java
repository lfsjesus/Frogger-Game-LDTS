package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.RockController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.model.game.elements.Lava;
import com.ldts.frogger.model.game.elements.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockControllerTest {
    private RockController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        arena.setLavas(Arrays.asList(new Lava(5, 5), new Lava(6, 5), new Lava(7, 5), new Lava(8, 5), new Lava(9, 5)));
        controller = new RockController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void FrogMovingWithRock() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Rock r = new Rock(new Position(5, 5), 1);
            arena.setRocks(List.of(r));
            frog = new Frog(5, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(6, 5), r.getPosition());
            assertEquals(new Position(6, 5), frog.getPosition());
        }
    }

    @Test
    void LogReset0() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Rock r = new Rock(new Position(-1, 5), 0);
            arena.setRocks(List.of(r));
            frog = new Frog(-1, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(9, 5), r.getPosition());
            assertEquals(new Position(9, 5), frog.getPosition());
        }
    }

    @Test
    void LogReset1() throws IOException {
        MusicManager manager = Mockito.mock(MusicManager.class);
        try (MockedStatic<MusicManager> configurationMockedStatic = Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Rock r = new Rock(new Position(11, 5), 1);
            arena.setRocks(List.of(r));
            frog = new Frog(11, 5);
            arena.setFrog(frog);
            controller.step(game, GUI.ACTION.NONE, 1000);
            assertEquals(new Position(0, 5), r.getPosition());
            assertEquals(new Position(0, 5), frog.getPosition());
        }
    }

}
