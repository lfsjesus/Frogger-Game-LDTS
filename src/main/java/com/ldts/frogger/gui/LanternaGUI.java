package com.ldts.frogger.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.ldts.frogger.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {

    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/FROGBLOCK_ALTERADO.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 40);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawFrog(Position position, int direction, String backgroundColor) {
        switch (direction) {
            case 0 -> drawText(position, "d", "#507436", backgroundColor);
            case 1 -> drawText(position, "e", "#507436", backgroundColor);
            case 2 -> drawText(position, "f", "#507436", backgroundColor);
            case 3 -> drawText(position, "n", "#507436", backgroundColor);
            case 4 -> drawText(position, "m", "#507436", backgroundColor);
            case 5 -> drawText(position, "l", "#507436", backgroundColor);
            case 6 -> drawText(position, "k", "#507436", backgroundColor);
            case 7 -> drawText(position, "c", "#507436", backgroundColor);
        }
    }

    @Override
    public void drawBackground(Position position, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.x(), position.y(), " ");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.x(), position.y(), text);
    }

    @Override
    public void drawText(Position position, String text, String foregroundColor, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        tg.setForegroundColor(TextColor.Factory.fromString(foregroundColor));
        tg.putString(position.x(), position.y(), text);
    }

    @Override
    public void drawTruck(Position position, String color, int direction) {
        if (direction == 1) {
            drawText(position, "z{", color);
        } else {
            drawText(position, "|}", color);
        }
    }


    @Override
    public void drawMotorbike(Position position, String color, int direction) {
        if (direction == 1) {
            drawText(position, "rs", color);
        } else {
            drawText(position, "tu", color);
        }
    }

    @Override
    public void drawVan(Position position, String color, int direction) {
        if (direction == 1) {
            drawText(position, "xy", color);
        } else {
            drawText(position, "vw", color);
        }
    }

    @Override
    public void drawCar(Position position, String color, int direction) {
        if (direction == 1) {
            drawText(position, "gh", color);
        } else {
            drawText(position, "ij", color);
        }

    }

    @Override
    public void drawTrain(Position position, String color, int direction) {
        if (direction == 1) {
            drawText(position, "[~[~[~[~[~[~[~]%", color);
        } else {
            drawText(position, "()()()()()()()*+", color);
        }

    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }


}
