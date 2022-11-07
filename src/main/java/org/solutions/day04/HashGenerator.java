package org.solutions.day04;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerator {
    public static String generate(String key) {
        return DigestUtils.md5Hex(key);
    }
}
