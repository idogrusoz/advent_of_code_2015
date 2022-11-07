package day02;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.solutions.day02.Ribbon;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RibbonTest {

    @Test
    void givenDimensions_whenFindTheShortestDistance_thenReturnsTheTwoShortestDimensions() {
        var ribbon = new Ribbon("2x3x4");
        List<Integer> actual = ribbon.shortestDimensions();
        Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(List.of(2, 3));
    }

    @Test
    void givenDimensions_whenCalculateTheLength_thenReturnsTheLengthOfTheRibbon() {
        var ribbon = new Ribbon("1x1x10");
        int actual = ribbon.lengthOfRibbon();
        assertEquals(actual, 4);
    }

    @Test
    void givenDimensions_whenCalculateTheBow_thenReturnsTheLengthOfTheBow() {
        var ribbon = new Ribbon("2x3x4");
        int actual = ribbon.lengthOfTheBow();
        assertEquals(actual, 24);
    }

    @Test
    void givenDimensions_whenCalculateTheTotalRibbonNeeded_thenReturnsTheTotalLength() {
        var ribbon = new Ribbon("2x3x4");
        int actual = ribbon.totalRibbonNeeded();
        assertEquals(actual, 34);
    }
}