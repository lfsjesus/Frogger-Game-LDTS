package com.ldts.frogger.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("START", "SCORE", "LEAVE");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedLeaderboard() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }


}
