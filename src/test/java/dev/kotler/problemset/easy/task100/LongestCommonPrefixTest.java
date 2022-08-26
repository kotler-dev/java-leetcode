package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/longest-common-prefix/

14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

 */

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    public static Stream<Arguments> containsStringArgs() {
        return Stream.of(
                Arguments.of("fl", new String[]{"flower", "flow", "flight"}),
                Arguments.of("flower", new String[]{"flower", "flower", "flower"}),
                Arguments.of("", new String[]{"dog", "racecar", "car"}),
                Arguments.of("a", new String[]{"ab", "a"}),
                Arguments.of("a", new String[]{"a", "a"}),
                Arguments.of("a", new String[]{"a"})
        );
    }

    @ParameterizedTest
    @MethodSource("containsStringArgs")
    void containsStringTest(String prefix, String[] data) {
        assertEquals(prefix, longestCommonPrefix(data)); // solution 1
        assertEquals(prefix, longestCommonPrefixSolutionTwo(data)); // solution 2
    }

    public static String longestCommonPrefix(String[] strings) {

        int minLengthWord = Integer.MAX_VALUE;
        for (String word : strings) {
            if (word.length() < minLengthWord) {
                minLengthWord = word.length();
            }
        }

        return getString(strings, minLengthWord);
    }

    public static String longestCommonPrefixSolutionTwo(String[] strings) {

        try {
            int minLengthWord = Arrays.stream(strings)
                    .mapToInt(String::length)
                    .min()
                    .getAsInt(); // NoSuchElementException
            return getString(strings, minLengthWord);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getString(String[] strings, int minLengthWord) {
        for (int currentIndex = 0; currentIndex < minLengthWord; currentIndex++) {
            for (String string : strings) {
                if (string.charAt(currentIndex) != strings[0].charAt(currentIndex)) {
                    return strings[0].substring(0, currentIndex);
                }
            }
        }
        return strings[0].substring(0, minLengthWord);
    }
}
