package org.solutions.day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DayThree {

    public void execute() {
        String file = "src/main/resources/day3.txt";
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String input = reader.readLine();
            reader.close();
            santaDeliversAlone(input);
            santaDeliversWithRobotSanta(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void santaDeliversAlone(String input) {
        var deliveryGrid = new DeliveryGrid();
        deliveryGrid.deliver(input);
        System.out.println("Santa delivers at least one present to " + deliveryGrid.countOfTheHousesReceivedAGift() + " houses \n");
    }

    private void santaDeliversWithRobotSanta(String input) {
        var team = new DeliveryTeam();
        team.deliver(input);
        System.out.println("Santa delivers at least one present to " +
                               team.totalAmountOfHousesDelivered() + " houses if he uses robot santa \n");
    }
}
