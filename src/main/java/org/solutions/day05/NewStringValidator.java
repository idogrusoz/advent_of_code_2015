package org.solutions.day05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewStringValidator {

    private final String value;

    public NewStringValidator(String value) {this.value = value;}

    public boolean validate() {
        return validateDuplicationGroups() && validateProperlyRepeatingLetter();
    }

    protected boolean validateDuplicationGroups() {
        Map<String, StringGroupChecker> stringGroups = new HashMap<>();
        for (var i = 0; i < value.length() - 1; i++) {
            var group = String.valueOf(value.charAt(i)) + value.charAt(i + 1);
            int index = i;
            stringGroups.compute(
                group,
                (k, v) -> v == null ?
                    new StringGroupChecker(1, List.of(index, index + 1)) :
                    incrementCountIfDoesntOverlap(index, v)
            );
        }
        return stringGroups.values().stream().anyMatch(v -> v.count() > 1);
    }

    private static StringGroupChecker incrementCountIfDoesntOverlap(int index, StringGroupChecker v) {
        return v.indexes().contains(index) ? v : v.increment();
    }

    public boolean validateProperlyRepeatingLetter() {
        for (var i = 0; i < value.length() - 2; i++) {
            if (String.valueOf(value.charAt(i)).equals(String.valueOf(value.charAt(i + 2)))) {
                return true;
            }
        }
        return false;
    }
}
