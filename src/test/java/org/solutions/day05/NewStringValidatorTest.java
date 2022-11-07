package org.solutions.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewStringValidatorTest {

    @Test
    void givenStringWithDuplicatingGroups_whenRuleApplied_thanReturnsTrue() {
        var validator = new NewStringValidator("qjhvhtzxzqqjkmpb");
        var actual = validator.validateDuplicationGroups();
        assertTrue(actual);
    }

    @Test
    void givenStringWithOverlappingDuplicatingGroups_whenRuleApplied_thanReturnsFalse() {
        var validator = new NewStringValidator("aaa");
        var actual = validator.validateDuplicationGroups();
        assertFalse(actual);
    }

    @Test
    void givenStringWithRepeatingLetterWithAnotherBetween_whenValidateForRepeatingLetters_thanReturnsTrue() {
        var validator = new NewStringValidator("abcdefeghi");
        var actual = validator.validateProperlyRepeatingLetter();
        assertTrue(actual);
    }

}