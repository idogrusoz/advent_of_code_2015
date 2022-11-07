package org.solutions.day05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DayFive {

    public void execute() {
        String file = "src/main/resources/day5.txt";
        var countOfNiceStringsWithOldRule = 0;
        var countOfNiceStringsWithNewRule = 0;
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countOfNiceStringsWithOldRule = getCountOfNiceStringsBasedOnOldRules(countOfNiceStringsWithOldRule, line);
                countOfNiceStringsWithNewRule = getCountOfNiceStringsBasedOnNewRules(countOfNiceStringsWithNewRule, line);
            }
            System.out.printf("Total count of nice strings is %s \n \n", countOfNiceStringsWithOldRule);
            System.out.printf("Total count of nice strings based on the new rules is %s \n \n", countOfNiceStringsWithNewRule);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCountOfNiceStringsBasedOnOldRules(int countOfNiceStrings, String line) {
        var validator = new StringValidator();
        if (validator.validate(line)) {
            countOfNiceStrings++;
        }
        return countOfNiceStrings;
    }

    private int getCountOfNiceStringsBasedOnNewRules(int countOfNiceStringsWithNewRule, String line) {
        var validator = new NewStringValidator(line);
        if (validator.validate()) {
            countOfNiceStringsWithNewRule++;
        }
        return countOfNiceStringsWithNewRule;
    }
}
