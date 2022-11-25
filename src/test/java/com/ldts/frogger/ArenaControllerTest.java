package com.ldts.frogger;

import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.RandomArenaBuilder;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArenaControllerTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 3, max = 20) int width, @ForAll @IntRange(min = 3, max = 20) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) {
        RandomArenaBuilder rab = new RandomArenaBuilder(width, height, 0);
        Arena arena = rab.createArena();
        FrogController controller = new FrogController(arena);

        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getFrog().getPosition().getX() >= 0);
            assert  (controller.getModel().getFrog().getPosition().getY() > 0);
            assert  (controller.getModel().getFrog().getPosition().getX() < width);
            assert (controller.getModel().getFrog().getPosition().getY() <= height);
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
