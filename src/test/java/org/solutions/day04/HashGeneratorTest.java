package org.solutions.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HashGeneratorTest {

    @Test
    void givenSecretKey_whenGenerate_thanMD5HashIsReturned() {
        var key = "abcdef609043";
        String actual = HashGenerator.generate(key);
        assertTrue(actual.startsWith("000001dbbfa"));
    }
}