package com.ldts.frogger.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().x());
        assertEquals(y, new Position(x, y).getLeft().y());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().x());
        assertEquals(y, new Position(x, y).getRight().y());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().x());
        assertEquals(y - 1, new Position(x, y).getUp().y());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().x());
        assertEquals(y + 1, new Position(x, y).getDown().y());
    }

    @Test
    void equals1() {
        Position p1 = new Position(1, 2);
        assertTrue(p1.equals(p1));
    }

    @Test
    void equals2() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        assertTrue(p1.equals(p2));
    }

    @Test
    void addPos() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        assertEquals(new Position(2, 4), p1.add(p2));
    }

    @Test
    void greaterOrEqual() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(0, 2);
        assertTrue(p1.greaterOrEqual(p2));
    }

    @Test
    void greaterOrEqual2() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        assertTrue(p1.greaterOrEqual(p2));
    }

    @Test
    void greaterOrEqual3() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 3);
        assertFalse(p1.greaterOrEqual(p2));
    }

    @Test
    void greaterOrEqual4() {
        Position p1 = new Position(2, 2);
        Position p2 = new Position(1, 2);
        assertTrue(p1.greaterOrEqual(p2));
    }

    @Test
    void lessOrEqual() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(0, 2);
        assertFalse(p1.lessOrEqual(p2));
    }

    @Test
    void lessOrEqual2() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        assertTrue(p1.lessOrEqual(p2));
    }

    @Test
    void lessOrEqual3() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 3);
        assertTrue(p1.lessOrEqual(p2));
    }

    @Test
    void lessOrEqual4() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(2, 2);
        assertTrue(p1.lessOrEqual(p2));
    }


}
