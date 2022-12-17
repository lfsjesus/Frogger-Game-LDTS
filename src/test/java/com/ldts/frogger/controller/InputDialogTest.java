package com.ldts.frogger.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputDialogTest {
    private InputDialog inputDialog;

    @BeforeEach
    void setUp() {
        inputDialog = Mockito.mock(InputDialog.class);
    }

    @Test
    void testInputDialog() {
        Mockito.when(inputDialog.getString()).thenReturn("test");
        assertEquals("test", inputDialog.getString());
    }
}
