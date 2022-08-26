package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/palindrome-number

9. Palindrome Number

Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeNumberTest {

    public static Stream<Arguments> isPalindromeArgs() {
        return Stream.of(
                Arguments.of(true, 121),
                Arguments.of(true, 1001),
                Arguments.of(false, 10),
                Arguments.of(false, -121)
        );
    }

    @ParameterizedTest
    @MethodSource("isPalindromeArgs")
    void isPalindromeTest(Boolean tf, int num) {
        assertEquals(tf, isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (x >= 0) {
            int num = x;
            while (num != 0) {
                arr.add(num % 10);
                num = num / 10;
            }
            System.out.println(arr);

            num = x;
            for (int i = arr.size() - 1; i > 0; i--) {
                if (arr.get(i) == num % 10) {
                    num = num / 10;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}