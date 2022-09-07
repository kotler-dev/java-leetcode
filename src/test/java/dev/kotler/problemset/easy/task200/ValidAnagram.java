package dev.kotler.problemset.easy.task200;

/*

https://leetcode.com/problems/valid-anagram/

242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

/*    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count;

        for (char c : s) {
            if (count.find(c) == count.end()) {
                count[c] = 1;
            } else {
                count[c] += 1;
            }
        }

        for (char c : t) {
            Map.Iterator it = count.find(c);
            if (it == count.end()) {
                return false;
            } else if (count[c] > 1) {
                count[c] -= 1;
            } else {
                count.erase(it);
            }
        }

        if (count.empty()) return true;
        return false;
    }*/
}
