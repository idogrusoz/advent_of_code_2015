package org.solutions.day06;

public class DimmableGrid extends Grid<DimmableLight> {

    public DimmableGrid(Coordinate start, Coordinate end) {
        super(start, end);
    }

    @Override
    protected void installLight(int i, int j) {
        lights.put(new Coordinate(i, j), new DimmableLight());
    }
}
