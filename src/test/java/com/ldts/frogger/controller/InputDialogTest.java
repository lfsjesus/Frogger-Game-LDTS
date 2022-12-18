package com.ldts.frogger.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputDialogTest {
    private InputDialog inputDialog;
    private JFrame f;

    @BeforeEach
    void init() {
        f = Mockito.mock(JFrame.class);
        inputDialog = new InputDialog(f, "name");
    }

    @Test
    void testInputDialog() {
        assertEquals("name", inputDialog.getString());
        Mockito.verify(f, Mockito.times(1)).dispose();
    }

}
