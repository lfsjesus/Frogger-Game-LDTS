package com.ldts.frogger.gui;

import com.ldts.frogger.model.Position;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawFrog(Position position, int direction);
    void drawObstacle(Position position);
    void drawMovingObject(Position position);

    void drawBackground(Position position, String color);

    void drawText(Position position, String text, String color);

    void drawText(Position position, String text, String foregroundColor, String backgroundColor);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

