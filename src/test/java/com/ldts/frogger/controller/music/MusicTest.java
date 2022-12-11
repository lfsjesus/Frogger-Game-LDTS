package com.ldts.frogger.controller.music;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {
    private Music music;
    private Clip clipMock;

    @BeforeEach
    void init() {
        String path = "/src/main/resources/sounds/soundtrack.wav";
        music = new Music(path);
        clipMock = Mockito.mock(Clip.class);
        music.setSound(clipMock);
    }

    @Test
    void createAndLoadSound() {
        String path = "/src/main/resources/sounds/soundtrack.wav";
        music = new Music(path);
        FloatControl floatControl = (FloatControl) music.getSound().getControl(FloatControl.Type.MASTER_GAIN);
        assertNotNull(music);
        assertEquals(-15.0f, floatControl.getValue());
    }

    @Test
    void isPlayingTrue() {
        Mockito.when(clipMock.isRunning()).thenReturn(true);
        assertTrue(music.isPlaying());
    }

    @Test
    void isPlayingFalse() {
        Mockito.when(clipMock.isRunning()).thenReturn(false);
        assertFalse(music.isPlaying());
    }

    @Test
    void start() throws InterruptedException {
        music.start();
        Thread.sleep(100);
        Mockito.verify(clipMock, Mockito.times(1)).setMicrosecondPosition(0);
        Mockito.verify(clipMock, Mockito.times(1)).start();
    }

    @Test
    void startLoop() throws InterruptedException {
        music.startLoop();
        Thread.sleep(100);
        Mockito.verify(clipMock, Mockito.times(1)).setMicrosecondPosition(0);
        Mockito.verify(clipMock, Mockito.times(1)).start();
        Mockito.verify(clipMock, Mockito.times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    void stop() throws InterruptedException {
        music.stop();
        Mockito.verify(clipMock, Mockito.times(1)).stop();
    }
}
