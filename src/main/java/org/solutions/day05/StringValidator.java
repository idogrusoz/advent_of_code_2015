package org.solutions.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringValidator {

    private static final List<String> VOWELS = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    private static final List<String> BAD_STRINGS = new ArrayList<>(Arrays.asList("ab", "cd", "pq", "xy"));

    private boolean hasDuplicateCharacters = false;
    private boolean containsNoBadStrings = true;
    private int vowelsCount = 0;

    public boolean validate(String value) {
        checkRules(value);
        return containsNoBadStrings && hasDuplicateCharacters && vowelsCount > 2;
    }

    private void checkRules(String value) {
        for (var i = 0; i < value.length(); i++) {
            var currentChar = String.valueOf(value.charAt(i));
            var nextChar = i != value.length() - 1 ? String.valueOf(value.charAt(i + 1)) : "";
            containsVowel(currentChar);
            containsSubsequentDuplicates(currentChar, nextChar);
            containsNoBadStrings(currentChar, nextChar);
        }
    }

    private void containsVowel(String currentChar) {
        if (VOWELS.contains(currentChar)) {
            vowelsCount++;
        }
    }

    private void containsSubsequentDuplicates(String currentChar, String nextChar) {
        if (!nextChar.isEmpty() && currentChar.equals(nextChar)) {
            hasDuplicateCharacters = true;
        }
    }

    private void containsNoBadStrings(String currentChar, String nextChar) {
        if (!nextChar.isEmpty() && BAD_STRINGS.contains(currentChar.concat(nextChar))) {
            containsNoBadStrings = false;
        }
    }
}
