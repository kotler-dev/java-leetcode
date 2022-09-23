package dev.kotler.problemset.task100;

/*

https://leetcode.com/problems/valid-parentheses/

20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationBracketsTest {
    private static Stream<Arguments> generateValueTest() {
        return Stream.of(
                Arguments.of(true, "()"),
                Arguments.of(true, "()[]{}"),
                Arguments.of(true, "([])"),
                Arguments.of(true, "([][])"),
                Arguments.of(true, "([{}])"),
                Arguments.of(false, "([)]"),
                Arguments.of(false, "([)"),
                Arguments.of(false, "(]"),
                Arguments.of(false, "}{}"),
                Arguments.of(false, "([{]})")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValueTest")
    void isNotValidTest(Boolean tf, String brackets) {
        assertEquals(tf, isValid(brackets));
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');

        for (char character : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(character);
            } else {
                Character peek = stack.peek();
                if (brackets.get(character) == peek) {
                    stack.pop();
                } else {
                    stack.push(character);
                }
            }
        }

        System.out.println(stack + " -> " + stack.empty());
        return stack.empty();
    }
}