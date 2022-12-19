package com.ldts.frogger.model;

import com.ldts.frogger.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    private Menu menu;
    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void isSelectedStart() {
        assertTrue(menu.isSelected(0) && menu.isSelectedStart());
    }

    @Test
    public void isSelectedExit() {
        assertFalse(menu.isSelectedExit());
    }

    @Test
    public void numberEntries() {
        assertEquals(3, menu.getNumberEntries());
    }
}
