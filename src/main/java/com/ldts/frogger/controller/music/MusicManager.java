package com.ldts.frogger.controller.music;

public class MusicManager {
    private Music backgroundMusic;
    private Music frog;
    private Music coin;
    private Music crash;
    private Music gameOver;
    private static MusicManager musicManager;

    private MusicManager() {
        backgroundMusic = new Music("/src/main/resources/sounds/sunsetCompressed.wav");
        frog = new Music("/src/main/resources/sounds/frog.wav");
        coin = new Music("/src/main/resources/sounds/coin.wav");
        crash = new Music("/src/main/resources/sounds/crash.wav");
        gameOver = new Music("/src/main/resources/sounds/gameOver.wav");
    }

    public static MusicManager getInstance() {
        if (musicManager == null) {
            musicManager = new MusicManager();
        }
        return musicManager;
    }

    public void setSoundTrack(Music soundTrack) {
        this.backgroundMusic = soundTrack;
    }

    public void setFrog(Music frog) {
        this.frog = frog;
    }

    public void setBackgroundMusic(Music backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
    }

    public void setCoin(Music coin) {
        this.coin = coin;
    }

    public void setCrash(Music crash) {
        this.crash = crash;
    }

    public void setGameOver(Music gameOver) {
        this.gameOver = gameOver;
    }

    public void start(Sounds sound) {
        switch(sound) {
            case SOUNDTRACK -> backgroundMusic.startLoop();
            case FROG ->  frog.start();
            case COIN -> coin.start();
            case CRASH -> crash.start();
            case GAMEOVER -> gameOver.start();
        }
    }

    public void stop(Sounds sound) {
        switch(sound) {
            case SOUNDTRACK -> backgroundMusic.stop();
            case FROG -> frog.stop();
            case COIN -> coin.stop();
            case CRASH -> crash.stop();
            case GAMEOVER -> gameOver.stop();

        }
    }

    public boolean isPlaying(Sounds sound) {
        return switch (sound) {
            case SOUNDTRACK -> backgroundMusic.isPlaying();
            case FROG -> frog.isPlaying();
            case COIN -> coin.isPlaying();
            case CRASH -> crash.isPlaying();
            case GAMEOVER -> gameOver.isPlaying();
        };
    }

    public void stopAll() {
        backgroundMusic.stop();
        frog.stop();
        coin.stop();
        crash.stop();
        gameOver.stop();
    }
}
