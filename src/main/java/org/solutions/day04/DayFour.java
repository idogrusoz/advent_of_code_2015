package org.solutions.day04;

public class DayFour {

    public void execute() {
        findTheMinimumNumberToReturnHashThatStartsWith("00000");
        findTheMinimumNumberToReturnHashThatStartsWith("000000");
    }

    private static void findTheMinimumNumberToReturnHashThatStartsWith(String startingNumbers) {
        var minimumNumberToMine = Miner.findTheNumberForMining("bgvyzdsv", startingNumbers);
        System.out.printf(
            "To mine AdventCoins, the lowest positive number Santa can use to find the hash that starts with %s is %s \n \n",
            startingNumbers,
            minimumNumberToMine
        );
    }
}
