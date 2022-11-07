package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WrappingPaperTest {

    @Test
    void givenDimensions_whenCalculate_itCalculatesTheCorrectSize() {
        var wrappingPaper = new WrappingPaper("2x3x4");
        int actual = wrappingPaper.calculateSurface();
        assertEquals(52, actual);
    }

    @Test
    void givenDimensions_whenFindTheSlack_thenSmallestPieceIsReturned() {
        var wrappingPaper = new WrappingPaper("1x1x10");
        int actual = wrappingPaper.findTheSlack();
        assertEquals(1, actual);
    }

    @Test
    void givenDimensions_whenCalculatePaperNeed_thenCorrectAmountIsReturned() {
        var wrappingPaper = new WrappingPaper("2x3x4");
        int actual = wrappingPaper.calculateTotalAmountOfPaper();
        assertEquals(58, actual);
    }

}