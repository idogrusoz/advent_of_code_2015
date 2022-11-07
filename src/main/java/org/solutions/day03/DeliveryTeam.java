package org.solutions.day03;

import java.util.HashSet;
import java.util.Set;

public class DeliveryTeam {
    private final Set<Coordinate> housesDelivered = new HashSet<>();

    public void deliver(String directions) {
        StringBuilder directionsForSanta = new StringBuilder();
        StringBuilder directionsForRobotSanta = new StringBuilder();
        for (int i = 0; i < directions.length(); i++) {
            if (i % 2 == 0) {
                directionsForSanta.append(directions.charAt(i));
            } else {
                directionsForRobotSanta.append(directions.charAt(i));
            }
        }
        executeDelivery(directionsForSanta.toString());
        executeDelivery(directionsForRobotSanta.toString());
    }

    private void executeDelivery(String directions) {
        var teamMember = new DeliveryGrid();
        teamMember.deliver(directions);
        housesDelivered.addAll(teamMember.getDeliveredLocations());
    }

    public int totalAmountOfHousesDelivered() {
        return housesDelivered.size();
    }
}
