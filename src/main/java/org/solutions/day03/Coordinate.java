package org.solutions.day03;

public record Coordinate(int x, int y) {
    public Coordinate up() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate down() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate left() {
        return new Coordinate(x - 1, y);
    }
}
