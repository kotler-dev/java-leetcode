package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/search-insert-position

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1, 3, 5, 6], target = 5
Output: 2

Example 2:
Input: nums = [1, 3, 5, 6], target = 2
Output: 1

Example 3:
Input: nums = [1, 3, 5, 6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 1=^4
nums contains distinct value sorted in ascending order.
-10^4 <= target <= 10^4

 */

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {
    public static Stream<Arguments> SearchInsertPositionArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 1, 0),
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("SearchInsertPositionArgs")
    void searchInsertPositionTest(int[] nums, int target, int output) {
        assertEquals(output, searchInsert(nums, target));
    }

    private int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int startIndex, int lastIndex, int target) {
        if (target <= nums[startIndex]) return startIndex;
        if (target > nums[lastIndex]) return lastIndex + 1;

        int middle = startIndex + ((lastIndex - startIndex) >> 1);

        return target == nums[middle]
                ? middle
                : binarySearch(nums, ++startIndex, --lastIndex, target);
    }
}