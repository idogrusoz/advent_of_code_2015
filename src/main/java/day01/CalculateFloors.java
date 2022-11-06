package day01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CalculateFloors {

    private final String POSITIVE_VALUE = "\\(";

    public void execute() {
        String file = "src/main/resources/day1.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String input = reader.readLine();
            reader.close();
            System.out.println(calculateFloors(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculateFloors(String str) {
        var negativeString = str.replaceAll(POSITIVE_VALUE, "");
        return str.length() - negativeString.length() * 2;
    }
}
