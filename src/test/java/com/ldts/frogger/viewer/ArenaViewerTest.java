package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Hero;
import com.ldts.frogger.model.game.elements.Monster;
import com.ldts.frogger.model.game.elements.Tree;
import com.ldts.frogger.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Tree(1, 2), new Tree(2, 3), new Tree(3, 4)));
        arena.setMonsters(Arrays.asList(new Monster(4, 5), new Monster(5, 6)));
        arena.setHero(new Hero(5, 8));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawMonster(Mockito.any(Position.class));
    }

    @Test
    void drawHero() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawHero(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawHero(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}