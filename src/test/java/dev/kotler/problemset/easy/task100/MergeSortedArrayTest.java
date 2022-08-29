package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/merge-sorted-array/

88. Merge Sorted Array

You are given two integer nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
be merged, and the last n elements are set to 0 and should be ignored.
nums2 has a length og n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The array we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The array we are merging are [1] and [].
The result of the merging is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1.
Output: [1]
Explanation: The array we are merging are [] and [1].
The result of the merging is [1].
Note that because m = 0, there are no elements in nums1.
The 0 is only there to ensure the merge result can fit in nums1.

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?

*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortedArrayTest {
    public static Stream<Arguments> mergeSortedArrayArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 5, 6}, new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3),
                Arguments.of(new int[]{1}, new int[]{1}, 1, new int[]{}, 0),
                Arguments.of(new int[]{1}, new int[]{1}, 1, new int[]{}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{0, 0, 0, 0, 0}, 0, new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{1}, new int[]{0}, 0, new int[]{1}, 1),
                Arguments.of(new int[]{-1, 0, 0, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 3, 0, 0, 0, 0, 0, 0}, 3, new int[]{-1, 1, 1, 1, 2, 3}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("mergeSortedArrayArgs")
    void merge(int[] result, int[] nums1, int m, int[] nums2, int n) {

        if (m >= 1 && n >= 1) {
            System.arraycopy(nums2, 0, nums1, nums1.length - n, nums2.length);
        } else {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }

        Arrays.sort(nums1);
        Assertions.assertArrayEquals(result, nums1);
    }
}
