package dev.kotler.problemset.task300;

/*

https://leetcode.com/problems/reverse-string/

344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.

*/

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            swap(s, i++, j--);
        }
    }

    static char[] swap(char[] ch, int i, int j) {
        char tempo = ch[i];
        ch[i] = ch[j];
        ch[j] = tempo;
        return ch;
    }
}
