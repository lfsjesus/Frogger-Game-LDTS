package com.ldts.frogger;

import com.ldts.frogger.gui.LanternaGUI;
import com.ldts.frogger.states.MenuState;
import com.ldts.frogger.model.menu.Menu;
import com.ldts.frogger.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());

    }

    // For testing purposes
    public Game(LanternaGUI gui) {
        this.gui = gui;
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        gui.close();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}