package com.ldts.frogger.model;

public record Position(int x, int y) {

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    public boolean lessOrEqual(Position position) {
        return x <= position.x && y <= position.y;
    }

    public boolean greaterOrEqual(Position position) {
        return x >= position.x && y >= position.y;
    }

    public Position add(Position position) {
        return new Position(x + position.x, y + position.y);
    }
}
