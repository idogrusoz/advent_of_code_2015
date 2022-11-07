package day02;

import java.util.List;
import java.util.stream.Stream;

public class Ribbon extends Gift {
    public Ribbon(String dimensions) {
        super(dimensions);
    }

    protected List<Integer> shortestDimensions() {
        return Stream.of(length, width, height).sorted(Integer::compareTo).toList().subList(0, 2);
    }

    protected int lengthOfRibbon() {
        return shortestDimensions().stream().reduce(0, Integer::sum) * 2;
    }

    protected int lengthOfTheBow() {
        return length * width * height;
    }

    public int totalRibbonNeeded() {
        return lengthOfRibbon() + lengthOfTheBow();
    }
}
