package org.solutions.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidatorTest {

    @Test
    void givenANiceString_whenValidate_thenReturnsTrue() {
        var validator = new StringValidator();
        var actual = validator.validate("ugknbfddgicrmopn");
        assertTrue(actual);
    }

    @Test
    void givenAnotherNiceString_whenValidate_thenReturnsTrue() {
        var validator = new StringValidator();
        var actual = validator.validate("aaa");
        assertTrue(actual);
    }

    @Test
    void givenANaughtyStringWithDoubleLetters_whenValidate_thenReturnsFalse() {
        var validator = new StringValidator();
        var actual = validator.validate("jchzalrnumimnmhp");
        assertFalse(actual);
    }

    @Test
    void givenANaughtyStringWithBadString_whenValidate_thenReturnsFalse() {
        var validator = new StringValidator();
        var actual = validator.validate("haegwjzuvuyypxyu");
        assertFalse(actual);
    }

    @Test
    void givenANaughtyStringWithOneVowel_whenValidate_thenReturnsFalse() {
        var validator = new StringValidator();
        var actual = validator.validate("dvszwmarrgswjxmb");
        assertFalse(actual);
    }
}