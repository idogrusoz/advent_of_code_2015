package org.solutions.day06;

public class SimpleGrid extends Grid<LightBulb> {

    public SimpleGrid(Coordinate start, Coordinate end) {
        super(start, end);
    }

    @Override
    protected void installLight(int i, int j) {
        lights.put(new Coordinate(i, j), new LightBulb());
    }
}
