package org.solutions.day06;

public class DimmableGrid extends Grid<DimmableLight> {

    @Override
    protected void putIfAbsent(Coordinate coordinate) {
        lights.putIfAbsent(coordinate, new DimmableLight());
    }
}
