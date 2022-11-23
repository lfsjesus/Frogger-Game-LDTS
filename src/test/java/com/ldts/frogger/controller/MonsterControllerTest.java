package com.ldts.frogger.controller;

import com.ldts.frogger.Game;
import com.ldts.frogger.controller.game.MonsterController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.elements.Hero;
import com.ldts.frogger.model.game.elements.Monster;
import com.ldts.frogger.model.game.elements.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterControllerTest {
    private MonsterController controller;
    private Hero hero;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new MonsterController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Tree(4, 5),
                new Tree(6, 5),
                new Tree(5, 4),
                new Tree(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Tree(4, 5),
                new Tree(6, 5),
                new Tree(5, 4)
        ));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}