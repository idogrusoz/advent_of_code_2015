package org.solutions.day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DaySix {
    public void execute() {
        String file = "src/main/resources/day6.txt";
        var grid = new SimpleGrid(new Coordinate(0, 0), new Coordinate(999, 999));
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                grid.execute(line);
            }
            System.out.printf("Total count of lights on is %s \n \n", grid.getTheStateOfTheLights());
        } catch (
            IOException e) {
            throw new RuntimeException(e);
        }
    }
}
