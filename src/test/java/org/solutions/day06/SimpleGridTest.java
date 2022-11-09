package org.solutions.day06;

import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleGridTest {

    @Test
    void givenATurnOnCommand_whenCoordinatesExtracted_thenReturnsCorrectValues() {
        var expected = List.of(Pair.create(599, 989), Pair.create(806, 993));
        var grid = new SimpleGrid();
        var command = "turn on 599,989 through 806,993";
        var actual = grid.getTurnOnCoordinates(command);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void givenATurnOffCommand_whenCoordinatesExtracted_thenReturnsCorrectValues() {
        var expected = List.of(Pair.create(448, 208), Pair.create(645, 684));
        var grid = new SimpleGrid();
        var command = "turn off 448,208 through 645,684";
        var actual = grid.getTurnOffCoordinates(command);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void givenAToggleCommand_whenCoordinatesExtracted_thenReturnsCorrectValues() {
        var expected = List.of(Pair.create(50, 472), Pair.create(452, 788));
        var grid = new SimpleGrid();
        var command = "toggle 50,472 through 452,788\n";
        var actual = grid.getToggleCoordinates(command);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void givenTurnOffCommand_whenFindActionType_thenCorrectActionTypeIsFound() {
        var grid = new SimpleGrid();
        grid.findActionType("turn off 448,208 through 645,684");
        assertEquals(ActionType.TURN_OFF, grid.getActionType());
    }

    @Test
    void givenATurnOnCommand_whenExecuted_thenCorrectAmountOfLightsAreTurnedOn() {
        var grid = new SimpleGrid();
        grid.execute("turn on 0,0 through 999,999");
        var lidLightsCount = grid.getTheStateOfTheLights();
        assertEquals(1000000, lidLightsCount);
    }

    @Test
    void givenATurnOffCommand_whenExecuted_thenCorrectAmountOfLightsAreTurnedOff() {
        var grid = new SimpleGrid();
        grid.execute("turn on 0,0 through 999,999");
        grid.execute("turn off 0,0 through 4,4");
        var lidLightsCount = grid.getTheStateOfTheLights();
        assertEquals(999975, lidLightsCount);
    }

    @Test
    void givenAToggleCommand_whenExecuted_thenCorrectAmountOfLightsAreTurnedOff() {
        var grid = new SimpleGrid();
        grid.execute("toggle 0,0 through 4,4");
        var lidLightsCount = grid.getTheStateOfTheLights();
        assertEquals(25, lidLightsCount);
    }
}