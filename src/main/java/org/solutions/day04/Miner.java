package org.solutions.day04;

public class Miner {
    public static int findTheNumberForMining(String key, String startingNumbers) {
        return correctNumberForMining(key, startingNumbers);
    }

    private static int correctNumberForMining(String key, String startingNumbers) {
        String hash = "";
        var code = 0;
        while (!hash.startsWith(startingNumbers)) {
            code++;
            hash = HashGenerator.generate(key + code);
        }
        return code;
    }
}
