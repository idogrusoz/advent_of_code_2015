package org.solutions.day06;

public class SimpleGrid extends Grid<LightBulb> {

    public SimpleGrid(Coordinate start, Coordinate end) {
        installTheLights(start, end);
    }

    protected void installTheLights(Coordinate start, Coordinate end) {
        for (var i = start.x(); i <= end.x(); i++) {
            for (var j = start.y(); j <= end.y(); j++) {
                lights.put(new Coordinate(i, j), new LightBulb());
            }
        }
    }
}
