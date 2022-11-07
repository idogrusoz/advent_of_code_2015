package org.example;

import day01.DayOne;
import day02.DayTwo;
import day03.DayThree;

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