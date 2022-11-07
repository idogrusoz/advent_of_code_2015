package org.solutions.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinerTest {

    @Test
    void givenAKey_whenMined_findsTheLowestIntegerToMatchTheCriteria() {
        var key = "abcdef";
        var startingNumbers = "00000";
        var expected = 609043;
        int actual = Miner.findTheNumberForMining(key, startingNumbers);
        assertEquals(actual, expected);
    }
}