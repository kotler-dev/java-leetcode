package dev.kotler.problemset.task100;
/*

https://leetcode.com/problems/length-of-last-word/

58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

*/

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - 1 - s.lastIndexOf(" ");
    }

    public static void main(String[] args) {
//        var r = lengthOfLastWord("Hello World");
        var r = lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(r);
    }

    /*
    int lengthOfLastWord(string s) {
        int ans = 0;
        int n = s.size();
        int i = n-1;

        while(i >= 0 && s[i] == ' ') --i;

        for(; (i >= 0) && (s[i] != ' '); --i) { ++ans; }

        return ans;
    }
     */
}
