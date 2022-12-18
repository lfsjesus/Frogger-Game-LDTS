package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.controller.music.Sounds;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.RandomArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import com.ldts.frogger.states.GameFinishedState;
import com.ldts.frogger.states.GameState;
import com.ldts.frogger.states.MenuState;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ArenaControllerTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 10, max = 12) int width, @ForAll @IntRange(min = 18, max = 20) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) throws IOException {
        RandomArenaBuilder rab = new RandomArenaBuilder(width, height);
        Arena arena = rab.createArena();
        ArenaController controller = new ArenaController(arena);
        Game game = new Game(Mockito.mock(LanternaGUI.class));

        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            for (GUI.ACTION action : actions) {
                if (controller.getModel().getFrog().getPosition().y() == 2)
                    controller.getModel().getFrog().setPosition(new Position(controller.getModel().getFrog().getPosition().x(), 3));
                controller.step(game, action, 100);
                assert (controller.getModel().getFrog().getPosition().x() >= 0);
                assert (controller.getModel().getFrog().getPosition().y() > 0);
                assert (controller.getModel().getFrog().getPosition().x() < width);
                assert (controller.getModel().getFrog().getPosition().y() <= height);
            }
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }

    @Test
    void endOfGame() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Game game = new Game(Mockito.mock(LanternaGUI.class));
            Arena arena = new Arena(10, 10);
            Frog frog = new Frog(10, 1);
            arena.setFrog(frog);
            game.setState(new GameState(arena));
            Arena.setLevel(5);
            ArenaController controller = new ArenaController(arena);
            controller.step(game, GUI.ACTION.UP, 100);
            assertTrue (game.getState() instanceof GameFinishedState);
        }
    }

    @Test
    void endOfLevel() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            int lev = Arena.getLevel();
            Game game = new Game(Mockito.mock(LanternaGUI.class));
            Arena arena = new Arena(10, 10);
            Frog frog = new Frog(10, 1);
            arena.setFrog(frog);
            game.setState(new GameState(arena));
            Arena.setLevel(1);
            ArenaController controller = new ArenaController(arena);
            controller.step(game, GUI.ACTION.UP, 100);
            assertEquals(lev + 1, Arena.getLevel());
        }
    }

    @Test
    void frogDied() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Game game = new Game(Mockito.mock(LanternaGUI.class));
            Arena arena = new Arena(10, 10);
            Frog frog = new Frog(10, 4);
            arena.setFrog(frog);
            game.setState(new GameState(arena));
            Frog.setLives(0);
            ArenaController controller = new ArenaController(arena);
            controller.step(game, GUI.ACTION.UP, 100);
            assertEquals(1, Arena.getLevel());
            assertTrue (game.getState() instanceof GameFinishedState);
        }
    }

    @Test
    void gameContinuesNormally() throws IOException {
        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            Game game = new Game(Mockito.mock(LanternaGUI.class));
            Arena arena = new Arena(10, 10);
            Frog frog = new Frog(10, 4);
            arena.setFrog(frog);
            game.setState(new GameState(arena));
            Frog.setLives(2);
            Arena.setLevel(1);
            ArenaController controller = new ArenaController(arena);
            controller.step(game, GUI.ACTION.UP, 100);
            assertEquals(1, Arena.getLevel());
            assertTrue (game.getState() instanceof GameState);
        }
    }
}
