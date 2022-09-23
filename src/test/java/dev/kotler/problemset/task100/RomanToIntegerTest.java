package dev.kotler.problemset.task100;

/*

https://leetcode.com/problems/roman-to-integer

13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerTest {

    private static Stream<Arguments> romanToIntValueTest() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntValueTest")
    void romanToIntTest(int num, String roman) {
        assertEquals(num, romanToInt(roman));
    }

    public static int romanToInt(String roman) {
        int result = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);

            if (i > 0 && hashMap.get(ch) > hashMap.get(roman.charAt(i - 1))) {
                result += hashMap.get(ch) - 2 * hashMap.get(roman.charAt(i - 1));
            } else {
                result += hashMap.get(ch);
            }
        }
        return result;
    }
}
