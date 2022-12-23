package com.ldts.frogger.gui;

import com.ldts.frogger.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawFrog(Position position, int direction, String backgroundColor);

    void drawBackground(Position position, String color);

    void drawText(Position position, String text, String color);

    void drawText(Position position, String text, String foregroundColor, String backgroundColor);

    void drawVan(Position position, String color, int direction);

    void drawCar(Position position, String color, int direction);

    void drawTruck(Position position, String color, int direction);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawMotorbike(Position position, String color, int direction);

    void drawTrain(Position position, String color, int direction);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

