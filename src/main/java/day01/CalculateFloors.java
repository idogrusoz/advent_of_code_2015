package day01;

public class CalculateFloors {

    private final String POSITIVE_VALUE = "\\(";

    public int calculateFloors(String str) {
        var negativeString = str.replaceAll(POSITIVE_VALUE, "");
        return str.length() - negativeString.length() * 2;
    }
}
