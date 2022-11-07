package org.solutions;

import org.solutions.day01.DayOne;
import org.solutions.day02.DayTwo;
import org.solutions.day03.DayThree;

public class Main {
    private static final DayOne day1 = new DayOne();
    private static final DayTwo day2 = new DayTwo();
    private static final DayThree day3 = new DayThree();

    public static void main(String[] args) {
        day1.execute();
        day2.execute();
        day3.execute();
    }
}