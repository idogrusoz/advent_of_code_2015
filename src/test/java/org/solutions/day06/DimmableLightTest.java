package org.solutions.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimmableLightTest {

    @Test
    void givenAnOnDimmableLight_whenReceivesATurnOnCommand_thenBrightnessIncreases() {
        var light = new DimmableLight();
        light.turnOn();
        light.turnOn();
        assertEquals(2, light.getState());
    }

    @Test
    void givenADimmableLightWithBrightnessTwo_whenReceivesATurnOfCommand_thenBrightnessReducedByOne() {
        var light = new DimmableLight();
        light.turnOn();
        light.turnOn();
        light.turnOff();
        assertEquals(1, light.getState());
    }

    @Test
    void givenAnOffDimmableLight_whenReceivesATurnOfCommand_thenBrightnessNeverGoesUnderZero() {
        var light = new DimmableLight();
        light.turnOff();
        assertEquals(0, light.getState());
    }

    @Test
    void givenAnOnDimmableLight_whenReceivesAToggleommand_thenBrightnessIncreasedByTwo() {
        var light = new DimmableLight();
        light.turnOn();
        light.toggle();
        assertEquals(3, light.getState());
    }

}