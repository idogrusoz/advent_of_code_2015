package org.solutions.day03;

import java.util.HashSet;
import java.util.Set;

public class DeliveryGrid {
    private Coordinate coordinate = new Coordinate(0, 0);

    private final Set<Coordinate> deliveredLocations = new HashSet<>();

    public Set<Coordinate> getDeliveredLocations() {
        return deliveredLocations;
    }

    public void deliver(String directions) {
        deliverToLocation();
        for (char ch : directions.toCharArray()) {
            moveToNewLocation(ch);
            deliverToLocation();
        }
    }

    private void deliverToLocation() {
        deliveredLocations.add(coordinate);
    }

    private void moveToNewLocation(char ch) {
        switch (ch) {
            case '^' -> coordinate = coordinate.up();
            case 'v' -> coordinate = coordinate.down();
            case '>' -> coordinate = coordinate.right();
            case '<' -> coordinate = coordinate.left();
        }

    }

    public int countOfTheHousesReceivedAGift() {
        return deliveredLocations.size();
    }
}
