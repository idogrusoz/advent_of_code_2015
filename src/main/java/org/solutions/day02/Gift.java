package org.solutions.day02;

import java.util.Arrays;

public class Gift {
    private final String DIMENSION_SEPERATOR = "x";

    protected final int length;
    protected final int width;
    protected final int height;

    public Gift(String dimensions) {
        var dimensionsList = Arrays.stream(dimensions.split(DIMENSION_SEPERATOR)).map(Integer::parseInt).toList();
        this.length = dimensionsList.get(0);
        this.width = dimensionsList.get(1);
        this.height = dimensionsList.get(2);
    }
}
