package com.ldts.frogger.controller;

import com.ldts.frogger.controller.game.ArenaController;
import com.ldts.frogger.controller.game.FrogController;
import com.ldts.frogger.controller.music.MusicManager;
import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.arena.Arena;
import com.ldts.frogger.model.game.arena.RandomArenaBuilder;
import com.ldts.frogger.model.game.elements.Frog;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;


public class ArenaControllerTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 10, max = 12) int width, @ForAll @IntRange(min = 18, max = 20) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) throws IOException {
        RandomArenaBuilder rab = new RandomArenaBuilder(width, height, 0,0,0, 0, 0, 0, 0,0,0, 0, 0, 0, 0, 0);
        Arena arena = rab.createArena();
        ArenaController controller = new ArenaController(arena);

        MusicManager manager= Mockito.mock(MusicManager .class);
        try(MockedStatic<MusicManager > configurationMockedStatic=Mockito.mockStatic(MusicManager.class)) {
            configurationMockedStatic.when(MusicManager::getInstance).thenReturn(manager);
            for (GUI.ACTION action : actions) {
                if (controller.getModel().getFrog().getPosition().getY() == 2)
                    controller.getModel().getFrog().setPosition(new Position(controller.getModel().getFrog().getPosition().getX(), 3));
                controller.step(null, action, 100);
                assert (controller.getModel().getFrog().getPosition().getX() >= 0);
                assert (controller.getModel().getFrog().getPosition().getY() > 0);
                assert (controller.getModel().getFrog().getPosition().getX() < width);
                assert (controller.getModel().getFrog().getPosition().getY() <= height);
            }
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
