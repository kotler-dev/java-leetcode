package dev.kotler.problemset.task100;

/*

https://leetcode.com/problems/two-sum

1. Two Sum

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

class Solution {
  public int[] twoSum(int[] array, int target) {
    int[] result = null;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == target) {
          result = new int[]{i, j};
          break;
        }
      }
      if (result != null) {
        break;
      }
    }
    return result;
  }
}

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumTest {
    private static Stream<Arguments> twoSumArgs() {
        return Stream.of(
                Arguments.of(List.of(0, 1), List.of(2, 7, 11, 15), 9),
                Arguments.of(List.of(1, 2), List.of(3, 2, 4, 42), 6),
                Arguments.of(List.of(0, 1), List.of(3, 3), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("twoSumArgs")
    void twoSumTest(List<Integer> output, List<Integer> nums, int target) {
        System.out.printf("%s --- %s --- %s\n", output, nums, target);
        assertEquals(output, twoSum(nums, target));
    }

    public static List<Integer> twoSum(List<Integer> nums, int target) {

        List<Integer> integerList = IntStream
                .range(0, nums.size())
                .filter(idx ->
                        (idx > 0 && (nums.get(idx) + nums.get(idx - 1) == target)
                                || (idx + 1 < nums.size() && nums.get(idx) + nums.get(idx + 1) == target)))
                .boxed().toList();

        System.out.println(integerList);
        return integerList;
    }
}
