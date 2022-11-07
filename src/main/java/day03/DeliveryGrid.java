package day03;

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
            var x = coordinate.x();
            var y = coordinate.y();
            findNewCoordinate(ch, x, y);
            deliverToLocation();
        }
    }

    private void deliverToLocation() {
        deliveredLocations.add(coordinate);
    }

    private void findNewCoordinate(char ch, int x, int y) {
        switch (ch) {
            case '^' -> y++;
            case 'v' -> y--;
            case '>' -> x++;
            case '<' -> x--;
        }
        coordinate = new Coordinate(x, y);
    }

    public int countOfTheHousesReceivedAGift() {
        return deliveredLocations.size();
    }
}
