package org.solutions.day07;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WiresSetTest {

    @Test
    void givenValue_whenFindCommand_returnsTheCorrectCommand() {
        var commands = List.of("123 -> x", "ab AND bc -> y");
        var wiresSet = new WiresSet(commands);
        var actual = wiresSet.findCommand("x");
        assertEquals("123 -> x", actual);
    }

    @Test
    void givenASimpleAssignment_whenFindValue_thenItReturnsSignalAndWire() {
        var command = "123 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(123, actual);
    }

    @Test
    void givenAndCommand_whenFindValue_itReturnsTheCorrectResult() {
        var command = "123 AND 456 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(72, actual);
    }

    @Test
    void givenOrCommand_whenFindValue_itReturnsTheCorrectResult() {
        var command = "123 OR 456 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(507, actual);
    }

    @Test
    void givenLeftShiftCommand_whenFindValue_itReturnsTheCorrectResult() {
        var command = "123 LSHIFT 456 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(31488, actual);
    }

    @Test
    void givenRightShiftCommand_whenFindValue_itReturnsTheCorrectResult() {
        var command = "123 RSHIFT 456 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(0, actual);
    }

    @Test
    void givenNotCommand_whenFindValue_itReturnsTheCorrectResult() {
        var command = "NOT 123 -> x";
        var wiresSet = new WiresSet(List.of(command));
        int actual = wiresSet.findValue("x");
        assertEquals(-124, actual);
    }

    @Test
    void givenMultipleCommands_whenFindValue_itReturnsTheCorrectResult() {
        var command1 = "ab AND bc -> x";
        var command2 = "123 AND a -> ab";
        var command3 = "5 OR 6 -> b";
        var command4 = "c LSHIFT b -> bc";
        var command5 = "5 AND 6 -> c";
        var command6 = "NOT 66 -> a";
        var wiresSet = new WiresSet(List.of(command1, command2, command3, command4, command5, command6));
        int actual = wiresSet.findValue("x");
        assertEquals(0, actual);
    }

   /* @Test
    void givenExistingValue_whenAnalyzeCommand_thenItDoesntCalculate() {

    }

    @Test
    void givenASimpleAssignment_whenAnalyzeCommand_thenItSavesTheResult() {
        var command = "123 -> x";
        var wiresSet = new WiresSet();
        var expected = 123;
        wiresSet.executeCommand(List.of(command));
        var actual = wiresSet.getSignalList().get("x");
        assertEquals(expected, actual);
    }

    @Test
    void givenASimpleAssignmentWithExistingValue_whenAnalyzeCommand_thenItReadsFromTheSavedValue() {
        var command = "123 -> x";
        var expected = 123;
        var wiresSet = new WiresSet();
        wiresSet.executeCommand(List.of(command));
        var newCommand = "x -> y";
        wiresSet.executeCommand(List.of(newCommand));
        var actual = wiresSet.getSignalList().get("y");
        assertEquals(expected, actual);
    }

    @Test
    void givenACommandBitWiseOperator_whenExtractOperation_thenCorrectValueIsReturned() {
        var leftSide = "x AND y";
        var expected = BitWiseOperations.AND;
        var wiresSet = new WiresSet();
        var actual = wiresSet.findOperationType(leftSide);
        assertEquals(expected, actual);
    }

    @Test
    void givenACommandWithBitWiseOperator_whenCalculateValue_thenCorrectValueIsReturned() {
        var leftSide = "123 OR 456";
        var expected = 507;
        var wireSet = new WiresSet();
        var actual = wireSet.calculateValue(leftSide, BitWiseOperations.OR);
        assertEquals(expected, actual);
    }

    @Test
    void givenAComplementOperation_whenExecuted_thenTheCorrectValueIsAssigned() {
        var command = "NOT 123 -> h";
        var expected = 65412;
        var wireSet = new WiresSet();
        wireSet.executeCommand(List.of(command));
        var actual = wireSet.getSignalList().get("h");
        assertEquals(expected, actual);
    }

    @Test
    void givenACommandWithStringValue_whenExecuted_thenCorrectValueIsAssigned() {
        var command = "bn RSHIFT 2 -> bo";
        var wireSet = new WiresSet();
        wireSet.executeCommand(List.of(command));
        var expected = "é";
        var actual = wireSet.getSignalList().get("bo");
        assertEquals(expected, actual);
    }

    @Test
    void givenASetOfCommands_whenAllCommandsAreExecuted_thenResultIsEqualToExpectation() {
        var expected = Map.of("d", 72, "e", 507, "f", 492, "g", 114, "h", 65412, "i", 65079, "x", 123, "y", 456);
        var wireSet = new WiresSet();
        wireSet.executeCommand(List.of("123 -> x"));
        wireSet.executeCommand(List.of("456 -> y"));
        wireSet.executeCommand(List.of("x AND y -> d"));
        wireSet.executeCommand(List.of("x OR y -> e"));
        wireSet.executeCommand(List.of("x LSHIFT 2 -> f"));
        wireSet.executeCommand(List.of("y RSHIFT 2 -> g"));
        wireSet.executeCommand(List.of("NOT x -> h"));
        wireSet.executeCommand(List.of("NOT y -> i"));
        var actual = wireSet.getSignalList();
        Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }*/
}