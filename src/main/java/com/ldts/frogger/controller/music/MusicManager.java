package com.ldts.frogger.controller.music;

public class MusicManager {
    private Music backgroundMusic;
    private Music frog;
    private Music coin;
    private Music crash;

    private static MusicManager musicManager;

    private MusicManager() {
        backgroundMusic = new Music("/src/main/resources/sounds/soundtrack.wav");
        frog = new Music("/src/main/resources/sounds/frog.wav");
        coin = new Music("/src/main/resources/sounds/coin.wav");
        crash = new Music("/src/main/resources/sounds/crash.wav");
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

    public void start(Sounds sound) {
        switch(sound) {
            case SOUNDTRACK -> backgroundMusic.startLoop();
            case FROG ->  frog.start();
            case COIN -> coin.start();
            case CRASH -> crash.start();
        }
    }

    public void stop(Sounds sound) {
        switch(sound) {
            case SOUNDTRACK -> backgroundMusic.stop();
            case FROG -> frog.stop();
            case COIN -> coin.stop();
            case CRASH -> crash.stop();

        }
    }

    public boolean isPlaying(Sounds sound) {
        return switch (sound) {
            case SOUNDTRACK -> backgroundMusic.isPlaying();
            case FROG -> frog.isPlaying();
            case COIN -> coin.isPlaying();
            case CRASH -> crash.isPlaying();
        };
    }

    public void stopAll() {
        backgroundMusic.stop();
        frog.stop();
        coin.stop();
        crash.stop();
    }
}
