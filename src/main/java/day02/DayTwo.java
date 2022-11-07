package day02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

    public void execute() {
        String file = "src/main/resources/day2.txt";
        List<Integer> dimensions = new ArrayList<>();
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var paper = new WrappingPaper(line);
                dimensions.add(paper.calculateTotalAmountOfPaper());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var totalAmountOfPaperNecessary = dimensions.stream().reduce(0, Integer::sum);
        System.out.println("Total amount of wrapping paper needed by the goblins is: " + totalAmountOfPaperNecessary);
    }
}
