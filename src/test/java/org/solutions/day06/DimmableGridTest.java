package org.solutions.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimmableGridTest {

    @Test
    void givenADimmableGrid_whenTurOn_thenBrightnessIncreases() {
        var grid = new DimmableGrid();
        grid.execute("turn on 0,0 through 0,0");
        var actual = grid.getTheStateOfTheLights();
        assertEquals(1, actual);
    }

    @Test
    void givenADimmableGrid_whenToggle_thenBrightnessIncreasesByTwo() {
        var grid = new DimmableGrid();
        grid.execute("toggle 0,0 through 999,999");
        var actual = grid.getTheStateOfTheLights();
        assertEquals(2000000, actual);
    }

}