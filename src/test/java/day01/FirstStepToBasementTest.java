package day01;

import org.junit.jupiter.api.Test;
import org.solutions.day01.FirstStepToBasement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstStepToBasementTest {

    FirstStepToBasement firstStepToBasement = new FirstStepToBasement();

    @Test
    void givenAString_whenFindFirstStepToBasement_thenRightValueIsReturned() {
        var str = "()())";
        int actual = firstStepToBasement.findTheIndexOfTheChar(str);
        assertEquals(5, actual);
    }
}