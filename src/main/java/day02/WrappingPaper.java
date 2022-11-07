package day02;

import java.util.Arrays;

public class WrappingPaper {
    private final String DIMENSION_SEPERATOR = "x";

    private final int length;
    private final int width;
    private final int height;

    public WrappingPaper(String dimensions) {
        var dimensionsList = Arrays.stream(dimensions.split(DIMENSION_SEPERATOR)).map(Integer::parseInt).toList();
        this.length = dimensionsList.get(0);
        this.width = dimensionsList.get(1);
        this.height = dimensionsList.get(2);
    }

    protected int calculateSurface() {
        return 2 * (lengthTimesWidth() + widthTimesHeight() + lengthTimesHeight());
    }

    private int lengthTimesWidth() {
        return length * width;
    }

    private int widthTimesHeight() {
        return width * height;
    }

    private int lengthTimesHeight() {
        return length * height;
    }

    protected int findTheSlack() {
        return Math.min(lengthTimesHeight(), Math.min(lengthTimesWidth(), widthTimesHeight()));
    }

    public int calculateTotalAmountOfPaper() {
        return calculateSurface() + findTheSlack();
    }
}
