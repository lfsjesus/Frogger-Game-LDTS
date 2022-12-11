package com.ldts.frogger.controller.music;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicManagerTest {

    MusicManager musicManagerTest;
    Music backgroundMusic = Mockito.mock(Music.class);
    Music coin = Mockito.mock(Music.class);
    Music frog = Mockito.mock(Music.class);
    Music crash = Mockito.mock(Music.class);


    @BeforeEach
    void initMusicManager() {
        MusicManager musicManager = MusicManager.getInstance();
        musicManager.setSoundTrack(backgroundMusic);
        musicManager.setFrog(frog);
        musicManager.setCoin(coin);
        musicManager.setCrash(crash);
        musicManagerTest = Mockito.spy(musicManager);
    }

    @Test
    void startSoundTrack() {
        musicManagerTest.start(Sounds.SOUNDTRACK);
        Mockito.verify(backgroundMusic, Mockito.times(1)).startLoop();
    }

    @Test
    void startFrog() {
        musicManagerTest.start(Sounds.FROG);
        Mockito.verify(frog, Mockito.times(1)).start();
    }

    @Test
    void startCrash() {
        musicManagerTest.start(Sounds.CRASH);
        Mockito.verify(crash, Mockito.times(1)).start();
    }

    @Test
    void startCoin() {
        musicManagerTest.start(Sounds.COIN);
        Mockito.verify(coin, Mockito.times(1)).start();
    }

    @Test
    void isPlayingSoundTrackTrue() {
        Mockito.when(backgroundMusic.isPlaying()).thenReturn(true);
        boolean playing = musicManagerTest.isPlaying(Sounds.SOUNDTRACK);
        assertTrue(playing);
    }

    @Test
    void isPlayingSoundTrackFalse() {
        Mockito.when(backgroundMusic.isPlaying()).thenReturn(false);
        boolean playing = musicManagerTest.isPlaying(Sounds.SOUNDTRACK);
        assertFalse(playing);
    }

    @Test
    void isPlayingFrogTrue() {
        Mockito.when(frog.isPlaying()).thenReturn(true);
        boolean playing = musicManagerTest.isPlaying(Sounds.FROG);
        assertTrue(playing);
    }

    @Test
    void isPlayingFrogFalse() {
        Mockito.when(frog.isPlaying()).thenReturn(false);
        boolean playing = musicManagerTest.isPlaying(Sounds.FROG);
        assertFalse(playing);
    }

    @Test
    void isPlayingCrashTrue() {
        Mockito.when(crash.isPlaying()).thenReturn(true);
        boolean playing = musicManagerTest.isPlaying(Sounds.CRASH);
        assertTrue(playing);
    }

    @Test
    void isPlayingCrashFalse() {
        Mockito.when(crash.isPlaying()).thenReturn(false);
        boolean playing = musicManagerTest.isPlaying(Sounds.CRASH);
        assertFalse(playing);
    }

    @Test
    void isPlayingCoinTrue() {
        Mockito.when(coin.isPlaying()).thenReturn(true);
        boolean playing = musicManagerTest.isPlaying(Sounds.COIN);
        assertTrue(playing);
    }

    @Test
    void isPlayingCoinFalse() {
        Mockito.when(coin.isPlaying()).thenReturn(false);
        boolean playing = musicManagerTest.isPlaying(Sounds.COIN);
        assertFalse(playing);
    }

    @Test
    void stopAll() {
        musicManagerTest.stopAll();
        Mockito.verify(backgroundMusic, Mockito.times(1)).stop();
        Mockito.verify(frog, Mockito.times(1)).stop();
        Mockito.verify(crash, Mockito.times(1)).stop();
        Mockito.verify(coin, Mockito.times(1)).stop();
    }


}
