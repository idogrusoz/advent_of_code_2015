package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DayThree {

    public void execute() {
        String file = "src/main/resources/day3.txt";
        var deliveryGrid = new DeliveryGrid();
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String input = reader.readLine();
            reader.close();
            deliveryGrid.deliver(input);
            System.out.println("Santa delivers at least on present to " + deliveryGrid.countOfTheHousesReceivedAGift() + " houses");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
