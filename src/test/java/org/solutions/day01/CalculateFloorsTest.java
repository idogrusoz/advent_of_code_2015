package org.solutions.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateFloorsTest {
    CalculateFloors calculator = new CalculateFloors();

    @Test
    void givenEqualAmountOfParenthesis_whenCalculateFloor_itCalculatesCorrectly() {
        var str = "(())";
        var actual = calculator.calculateFloors(str);
        assertEquals(actual, 0);
    }

    @Test
    void givenNegativeValueOfParenthesis_whenCalculateFloor_itCalculatesCorrectly() {
        var str = ")())())";
        var actual = calculator.calculateFloors(str);
        assertEquals(actual, -3);
    }
}