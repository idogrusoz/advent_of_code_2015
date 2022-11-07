package org.solutions.day04;

public class DayFour {

    public void execute() {
        findTheMinimumNumberToReturnHashThatStartsWith("00000");
        findTheMinimumNumberToReturnHashThatStartsWith("000000");
    }

    private static void findTheMinimumNumberToReturnHashThatStartsWith(String startingNumbers) {
        var minimumNumberToMine = Miner.findTheNumberForMining("bgvyzdsv", startingNumbers);
        System.out.println(
            "To mine AdventCoins, the lowest positive number Santa can use to find the hash that starts with " + startingNumbers + " is "
                + minimumNumberToMine + "\n");
    }
}
