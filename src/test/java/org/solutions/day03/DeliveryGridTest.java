package org.solutions.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryGridTest {

    @Test
    void givenDirections_whenDelivered_returnsTheCorrectNumberOfHousesReceivedAtLeastOneGift() {
        var grid = new DeliveryGrid();
        grid.deliver("^>v<");
        int actual = grid.countOfTheHousesReceivedAGift();
        Assertions.assertEquals(actual, 4);
    }

}