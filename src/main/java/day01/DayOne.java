package day01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DayOne {
    private final CalculateFloors calculateFloors = new CalculateFloors();
    private final FirstStepToBasement firstStepToBasement = new FirstStepToBasement();

    public void execute() {
        String file = "src/main/resources/day1.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String input = reader.readLine();
            reader.close();
            System.out.println("Santa will be at the floor: " + calculateFloors.calculateFloors(input) + "\n");
            System.out.println("Position of the first instruction that will make santa enter the floor -1 is: "
                                   + firstStepToBasement.findTheIndexOfTheChar(input) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
