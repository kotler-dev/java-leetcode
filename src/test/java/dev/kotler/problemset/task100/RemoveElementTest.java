package dev.kotler.problemset.task100;

/*

https://leetcode.com/problems/remove-element/

27. Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:
The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementTest {

    public static Stream<Arguments> removeElementArgs() {
        return Stream.of(
                Arguments.of(2, new int[]{3, 2, 2, 3}, 3),
                Arguments.of(5, new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2),
                Arguments.of(1, new int[]{4, 5}, 5),
                Arguments.of(0, new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("removeElementArgs")
    void removeElementTest(int expected, int[] nums, int val) {
        assertEquals(expected, removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int lastIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[lastIndex];
                nums[lastIndex--] = 101;
                i--;
            }
        }

        int[] array = Arrays.stream(nums).filter(num -> num != 101).toArray();

        return array.length;
    }
}
