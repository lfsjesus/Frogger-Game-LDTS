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
    void drawFrog0() {
        gui.drawFrog(new Position(2,2), 0, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ē");
    }

    @Test
    void drawFrog1() {
        gui.drawFrog(new Position(2,2), 1, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ĕ");
    }

    @Test
    void drawFrog2() {
        gui.drawFrog(new Position(2,2), 2, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ĕ");
    }

    @Test
    void drawFrog3() {
        gui.drawFrog(new Position(2,2), 3, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ĩ");
    }

    @Test
    void drawFrog4() {
        gui.drawFrog(new Position(2,2), 4, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ħ");
    }

    @Test
    void drawFrog5() {
        gui.drawFrog(new Position(2,2), 5, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ħ");
    }

    @Test
    void drawFrog6() {
        gui.drawFrog(new Position(2,2), 6, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ĥ");
    }

    @Test
    void drawFrog7() {
        gui.drawFrog(new Position(2,2), 7, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ē");
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
    void drawCar0() {
        gui.drawCar(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Īī");
    }

    @Test
    void drawCar1() {
        gui.drawCar(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ėĘ");
    }

    @Test
    void drawBackground() {
        gui.drawBackground(new Position(2,2), "#FFFFFF");
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, " ");
    }

    @Test
    void drawTruck0() {
        gui.drawTruck(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Āā");
    }

    @Test
    void drawTruck1() {
        gui.drawTruck(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ăă");
    }

    @Test
    void drawMotorbike0() {
        gui.drawMotorbike(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ļĽ");
    }

    @Test
    void drawMotorbike1() {
        gui.drawMotorbike(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ĸĹ");
    }

    @Test
    void drawVan0() {
        gui.drawVan(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ģĤ");
    }

    @Test
    void drawVan1() {
        gui.drawVan(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "Ķķ");
    }

    @Test
    void drawTrain0() {
        gui.drawTrain(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ŉŊŋŌŋŌŋŌŋŌŋŌŋŌŋŌ");
    }

    @Test
    void drawTrain1() {
        gui.drawTrain(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ŚśŚśŚśŚśŚśŚśŚśŜŝ");
    }

}
