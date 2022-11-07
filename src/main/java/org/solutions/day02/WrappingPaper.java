package org.solutions.day02;

public class WrappingPaper extends Gift {

    public WrappingPaper(String dimensions) {
        super(dimensions);
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
