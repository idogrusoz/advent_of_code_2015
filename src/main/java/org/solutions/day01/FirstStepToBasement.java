package org.solutions.day01;

public class FirstStepToBasement {
    private final String POSITIVE_VALUE = "(";

    public int findTheIndexOfTheChar(String str) {
        int floor = 0;
        int index = 0;
        for (var i = 0; i < str.length(); i++) {
            var ch = String.valueOf(str.charAt(i));
            if (ch.equals(POSITIVE_VALUE)) {
                floor++;
            } else {
                floor--;
            }
            if (floor == -1) {
                index = i + 1;
                break;
            }
        }
        return index;
    }
}
