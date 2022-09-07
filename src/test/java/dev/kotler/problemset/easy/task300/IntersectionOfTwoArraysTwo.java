package dev.kotler.problemset.easy.task300;

/*

https://leetcode.com/problems/intersection-of-two-arrays-ii/

350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ans = new ArrayList<>();

        int cur1 = 0, cur2 = 0;

        while(cur1 < nums1.length && cur2 < nums2.length){
            if(nums1[cur1] == nums2[cur2]){
                ans.add(nums1[cur1]);
                cur1++;
                cur2++;
            }else if(nums1[cur1] < nums2[cur2]){
                cur1++;
            }else{
                cur2++;
            }
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}
