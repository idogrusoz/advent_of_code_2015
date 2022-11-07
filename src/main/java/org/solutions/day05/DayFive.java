package org.solutions.day05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DayFive {

    public void execute() {
        String file = "src/main/resources/day5.txt";
        var countOfNiceStrings = 0;
        var count = 0;
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
                var validator = new StringValidator();
                if (validator.validate(line)) {
                    countOfNiceStrings++;
                }
            }
            System.out.printf("Total count of nice strings out of %s strings is %s \n%n", count, countOfNiceStrings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
