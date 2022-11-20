package org.solutions.day07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DaySeven {
    public void execute() {
        String file = "src/main/resources/day7.txt";
        List<String> instructions = new ArrayList<>();
        try (var reader = new BufferedReader
            (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                instructions.add(line);
            }
            var wires = new WiresSet(instructions);
            solvePuzzle1(wires);
        } catch (
            IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solvePuzzle1(WiresSet wires) {
        var result = wires.findValue("a");
        System.out.printf("When all wires connected the signal value of the wire a is %s \n \n", result);
    }
}
