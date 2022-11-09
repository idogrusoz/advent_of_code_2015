package org.solutions.day06;

public class SimpleGrid extends Grid<LightBulb> {
    @Override
    protected void putIfAbsent(Coordinate coordinate) {
        lights.putIfAbsent(coordinate, new LightBulb());
    }
}
