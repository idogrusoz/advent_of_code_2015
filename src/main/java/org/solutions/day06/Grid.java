package org.solutions.day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

import static org.solutions.day06.ActionType.TOGGLE;
import static org.solutions.day06.ActionType.TURN_OFF;
import static org.solutions.day06.ActionType.TURN_ON;

public abstract class Grid<T extends LightBulb> {

    private static final String THROUGH = "through";
    Map<Coordinate, T> lights = new HashMap<>();
    private ActionType actionType;

    public void execute(String command) {
        findActionType(command);
        List<Pair<Integer, Integer>> coordinates = switch (actionType) {
            case TURN_ON -> getTurnOnCoordinates(command);
            case TURN_OFF -> getTurnOffCoordinates(command);
            case TOGGLE -> getToggleCoordinates(command);
        };
        handleCommand(coordinates);
    }

    protected List<Pair<Integer, Integer>> getTurnOnCoordinates(String command) {
        return extractCoordinates(command, TURN_ON);
    }

    private static List<Pair<Integer, Integer>> extractCoordinates(String command, ActionType actionType) {
        var coordinates =
            Arrays.stream(command.replace(actionType.toString().replace("_", " ").toLowerCase(), "")
                              .replace(THROUGH, ",")
                              .replaceAll(" ", "")
                              .replaceAll("\n", "")
                              .split(","))
                .map(Integer::parseInt)
                .toList();
        return List.of(Pair.create(coordinates.get(0), coordinates.get(1)), Pair.create(coordinates.get(2), coordinates.get(3)));
    }

    protected List<Pair<Integer, Integer>> getTurnOffCoordinates(String command) {
        return extractCoordinates(command, TURN_OFF);
    }

    protected List<Pair<Integer, Integer>> getToggleCoordinates(String command) {
        return extractCoordinates(command, TOGGLE);
    }

    private void handleCommand(List<Pair<Integer, Integer>> coordinates) {
        var startingCoordinates = coordinates.get(0);
        var endingCoordinates = coordinates.get(1);
        for (var i = startingCoordinates.getFirst(); i <= endingCoordinates.getFirst(); i++) {
            for (var j = startingCoordinates.getSecond(); j <= endingCoordinates.getSecond(); j++) {
                changeTheStateOfTheLightOnTheCoordinate(new Coordinate(i, j));
            }
        }
    }

    private void changeTheStateOfTheLightOnTheCoordinate(Coordinate coordinate) {
        switch (actionType) {
            case TURN_ON -> turnTheLightOn(coordinate);
            case TURN_OFF -> turnTheLightOff(coordinate);
            case TOGGLE -> toggleTheLight(coordinate);
        }
    }

    protected void turnTheLightOn(Coordinate coordinate) {
        putIfAbsent(coordinate);
        lights.get(coordinate).turnOn();
    }

    protected abstract void putIfAbsent(Coordinate coordinate);

    protected void turnTheLightOff(Coordinate coordinate) {
        putIfAbsent(coordinate);
        lights.get(coordinate).turnOff();
    }

    protected void toggleTheLight(Coordinate coordinate) {
        putIfAbsent(coordinate);
        lights.get(coordinate).toggle();
    }

    protected void findActionType(String command) {
        var commandStart = command.substring(0, 7);
        actionType = switch (commandStart) {
            case "turn on" -> TURN_ON;
            case "turn of" -> TURN_OFF;
            case "toggle " -> TOGGLE;
            default -> throw new IllegalArgumentException();
        };
    }

    protected ActionType getActionType() {
        return actionType;
    }

    public int getTheStateOfTheLights() {
        return lights.values().stream().map(LightBulb::getState).reduce(0, Integer::sum);
    }
}
