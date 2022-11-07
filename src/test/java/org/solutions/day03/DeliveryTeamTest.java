package org.solutions.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryTeamTest {

    @Test
    void givenDirections_whenDelivered_ItReturnsTheSumOfTheHousesThatReceivedAtLeastOneGift() {
        var team = new DeliveryTeam();
        team.deliver("^>v<");
        var actual = team.totalAmountOfHousesDelivered();
        assertEquals(actual, 3);
    }
}