package com.ldts.frogger.model;

import com.ldts.frogger.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(menu.getNumberEntries() == 3);
    }
}
