package dev.kotler.problemset.task100;

/*

https://leetcode.com/problems/implement-strstr/

28. Implement strStr()

Implement strStr().
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImplementStrTest {

    public static Stream<Arguments> implementStringArgs() {
        return Stream.of(
                Arguments.of("hello", "ll", 2),
                Arguments.of("ll", "hello", -1),
                Arguments.of("aaaaaa", "bba", -1),
                Arguments.of("a", "a", 0),
                Arguments.of("a", "b", -1),
                Arguments.of("aaa", "aaa", 0),
                Arguments.of("mississippi", "issip", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("implementStringArgs")
    void implementStringTest(String haystack, String needle, int output) {
        assertEquals(output, implementString(haystack, needle));
    }

    private int implementString(String haystack, String needle) {
//        return haystack.matches("^.*" + needle + "$") // variant with regexp
        return haystack.contains(needle)
                ? haystack.indexOf(needle.charAt(0)) != -1
                ? haystack.indexOf(needle) : 0
                : -1;
    }

//    Example 2
//    private int implementStringElvis(String haystack, String needle) {
//        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
//    }
}