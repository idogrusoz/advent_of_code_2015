package org.solutions.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.solutions.day07.BitWiseOperations.AND;
import static org.solutions.day07.BitWiseOperations.NOT;
import static org.solutions.day07.BitWiseOperations.OR;
import static org.solutions.day07.BitWiseOperations.RSHIFT;
import static org.solutions.day07.BitWiseOperations.SINGLE_VALUE;

public class WiresSet {

    private final String OUTPUT_CONNECTOR = " -> ";

    private final Map<String, Integer> signalList = new HashMap<>();
    private final List<String> commands;

    public WiresSet(List<String> commands) {
        this.commands = commands;
    }

    public String findCommand(String assignee) {
        return commands.stream().filter(c -> extractAssignee(c).equals(assignee)).findFirst().orElse(null);
    }

    private String extractAssignee(String command) {
        return command.split(OUTPUT_CONNECTOR)[1];
    }

    public int findValue(String assignee) {
        if (signalList.containsKey(assignee)) {
            return signalList.get(assignee);
        }
        var command = findCommand(assignee);
        var leftSide = command.split(OUTPUT_CONNECTOR)[0];
        var operationType = findOperationType(leftSide);
        List<String> leftSideValues = getLeftSideValues(leftSide, operationType);
        List<Integer> intValues = new ArrayList<>();
        findTheIntegerValuesOfTheLeftSide(leftSideValues, intValues);
        int result = calculateResult(operationType, intValues);
        signalList.put(assignee, result);
        return result;
    }

    protected BitWiseOperations findOperationType(String leftSide) {
        if (leftSide.contains(AND.toString())) {
            return AND;
        }
        if (leftSide.contains(OR.toString())) {
            return OR;
        }
        if (leftSide.contains(NOT.toString())) {
            return NOT;
        }
        if (leftSide.contains(BitWiseOperations.LSHIFT.toString())) {
            return BitWiseOperations.LSHIFT;
        }
        if (leftSide.contains(RSHIFT.toString())) {
            return RSHIFT;
        }
        return SINGLE_VALUE;
    }

    private List<String> getLeftSideValues(String leftSide, BitWiseOperations operationType) {
        return switch (operationType) {
            case AND, OR, LSHIFT, RSHIFT -> getLeftSideValuesForTwoValueOperation(leftSide, operationType);
            case NOT -> getLeftSideValuesForNotOperation(leftSide);
            case SINGLE_VALUE -> getLeftSideValuesForSingleValue(leftSide);
        };
    }

    private static List<String> getLeftSideValuesForTwoValueOperation(String leftSide, BitWiseOperations operation) {
        return Arrays.asList(leftSide.replace(" ", "").split(operation.toString()));
    }

    private static List<String> getLeftSideValuesForNotOperation(String leftSide) {
        return List.of(leftSide.replace(" ", "").split(NOT.toString())[1]);
    }

    private List<String> getLeftSideValuesForSingleValue(String leftSide) {
        return List.of(leftSide.trim());
    }

    private void findTheIntegerValuesOfTheLeftSide(List<String> leftSideValues, List<Integer> intValues) {
        for (var value : leftSideValues) {
            int intValue = isDigit(value) ? Integer.parseInt(value) : findValue(value);
            intValues.add(intValue);
        }
    }

    private boolean isDigit(String value) {
        var pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(value).matches();
    }

    private int calculateResult(BitWiseOperations operationType, List<Integer> intValues) {
        return switch (operationType) {
            case AND, OR, LSHIFT, RSHIFT -> handleTwoValuedOperation(intValues.get(0), intValues.get(1), operationType);
            case NOT -> handleNotOperation(intValues.get(0));
            case SINGLE_VALUE -> handleSingleValueOperation(intValues.get(0));
        };
    }

    private int handleTwoValuedOperation(int leftValue, int rightValue, BitWiseOperations operator) {
        return switch (operator) {
            case AND -> leftValue & rightValue;
            case OR -> leftValue | rightValue;
            case LSHIFT -> leftValue << rightValue;
            case RSHIFT -> leftValue >> rightValue;
            default -> 0;
        };
    }

    private int handleNotOperation(int leftSide) {
        return ~leftSide;
    }

    private int handleSingleValueOperation(int leftSide) {
        return leftSide;
    }
}
