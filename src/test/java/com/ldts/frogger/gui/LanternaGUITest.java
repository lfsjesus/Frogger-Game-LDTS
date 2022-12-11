package com.ldts.frogger.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textTg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textTg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textTg);
        gui = new LanternaGUI(screen);
    }

    @Test
    void drawFrog() {
        gui.drawFrog(new Position(2,2), 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ē");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "I'm a Frog", "#F0F0F0");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(240, 240, 240));
        Mockito.verify(textTg, Mockito.times(1)).putString(1, 1, "I'm a Frog");
    }

    @Test
    void drawTextWithBg() {
        gui.drawText(new Position(1, 1), "I'm a Frog", "#F0F0F0", "#FFFFFF");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(240, 240, 240));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textTg, Mockito.times(1)).putString(1, 1, "I'm a Frog");
    }

    @Test
    void drawCar() {
        gui.drawCar(new Position(2,2));
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ėĘ");
    }

    @Test
    void drawBackground() {
        gui.drawBackground(new Position(2,2), "#FFFFFF");
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, " ");
    }

}
