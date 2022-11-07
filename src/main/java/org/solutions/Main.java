package org.solutions;

import org.solutions.day01.DayOne;
import org.solutions.day02.DayTwo;
import org.solutions.day03.DayThree;
import org.solutions.day04.DayFour;
import org.solutions.day05.DayFive;

public class Main {
    private static final DayOne day1 = new DayOne();
    private static final DayTwo day2 = new DayTwo();
    private static final DayThree day3 = new DayThree();
    private static final DayFour day4 = new DayFour();
    private static final DayFive day5 = new DayFive();

    public static void main(String[] args) {
        day1.execute();
        day2.execute();
        day3.execute();
        day4.execute();
        day5.execute();
    }
}