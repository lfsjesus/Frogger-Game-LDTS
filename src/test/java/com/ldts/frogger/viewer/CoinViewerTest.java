package com.ldts.frogger.viewer;

import com.ldts.frogger.gui.GUI;
import com.ldts.frogger.model.Position;
import com.ldts.frogger.model.game.elements.Coin;
import com.ldts.frogger.viewer.game.CoinViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinViewerTest {
    private Coin coin;
    private CoinViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        coin = new Coin(new Position(1,1), "#000000");
        viewer = new CoinViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(coin.getPosition(), "ĺ", "#daac34", coin.getBackGroundColor());
        assertEquals(coin.getBackGroundColor(), "#000000");
    }

}
