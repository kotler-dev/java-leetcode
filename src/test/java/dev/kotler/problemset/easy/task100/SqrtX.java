package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/sqrtx/

69. Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

Example 1:
Input: x = 4
Output: 2

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

Constraints:
0 <= x <= 231 - 1

*/

public class SqrtX {
    public static int mySqrt(int x) {
        long n = 0;
        while (n * n <= x) n++;
        return (int) (n - 1);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2)); // 1
        System.out.println(mySqrt(3)); // 1
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(8)); // 2
        System.out.println(mySqrt(5)); // 2
    }
}
