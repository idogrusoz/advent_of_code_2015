package org.solutions.day05;

import java.util.List;

public record StringGroupChecker(int count, List<Integer> indexes) {
    public StringGroupChecker increment() {
        return new StringGroupChecker(count + 1, indexes);
    }
}
