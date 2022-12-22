package com.ldts.frogger.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "d");
    }

    @Test
    void drawFrog1() {
        gui.drawFrog(new Position(2,2), 1, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "e");
    }

    @Test
    void drawFrog2() {
        gui.drawFrog(new Position(2,2), 2, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "f");
    }

    @Test
    void drawFrog3() {
        gui.drawFrog(new Position(2,2), 3, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "n");
    }

    @Test
    void drawFrog4() {
        gui.drawFrog(new Position(2,2), 4, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "m");
    }

    @Test
    void drawFrog5() {
        gui.drawFrog(new Position(2,2), 5, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "l");
    }

    @Test
    void drawFrog6() {
        gui.drawFrog(new Position(2,2), 6, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "k");
    }

    @Test
    void drawFrog7() {
        gui.drawFrog(new Position(2,2), 7, "#000000");
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(80, 116, 54));
        Mockito.verify(textTg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "c");
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
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "ij");
    }

    @Test
    void drawCar1() {
        gui.drawCar(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "gh");
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
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "|}");
    }

    @Test
    void drawTruck1() {
        gui.drawTruck(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "z{");
    }

    @Test
    void drawMotorbike0() {
        gui.drawMotorbike(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "tu");
    }

    @Test
    void drawMotorbike1() {
        gui.drawMotorbike(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "rs");
    }

    @Test
    void drawVan0() {
        gui.drawVan(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "vw");
    }

    @Test
    void drawVan1() {
        gui.drawVan(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "xy");
    }

    @Test
    void drawTrain0() {
        gui.drawTrain(new Position(2,2), "#cc0000", 0);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "()()()()()()()*+");
    }

    @Test
    void drawTrain1() {
        gui.drawTrain(new Position(2,2), "#cc0000", 1);
        Mockito.verify(textTg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textTg, Mockito.times(1)).putString(2, 2, "[~[~[~[~[~[~[~]%");
    }

    @Test
    void getNextActionUp() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.UP, gui.getNextAction());
    }

    @Test
    void getNextActionDown() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.DOWN, gui.getNextAction());
    }

    @Test
    void getNextActionLeft() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.LEFT, gui.getNextAction());
    }

    @Test
    void getNextActionRight() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.RIGHT, gui.getNextAction());
    }

    @Test
    void getNextActionSelect() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.SELECT, gui.getNextAction());
    }

    @Test
    void getNextActionQuit() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
    }

    @Test
    void getNextActionEOF() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
    }

    @Test
    void getNextActionNone() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(screen.pollInput()).thenReturn(null);

        LanternaGUI gui = new LanternaGUI(screen);
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }
}
