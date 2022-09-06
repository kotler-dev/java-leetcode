package dev.kotler.problemset.easy.task200;

/*

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9]

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

*/

//Definition for a binary tree node.
class CSATreeNode {
    int val;
    CSATreeNode left;
    CSATreeNode right;

    CSATreeNode() {
    }

    CSATreeNode(int val) {
        this.val = val;
    }

    CSATreeNode(int val, CSATreeNode left, CSATreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConvertSortedArrayToBinarySearchTree {

    public CSATreeNode buildTree ( int[] nums, int start, int end){
        if (end + 1 - start < 1) return null;
        int mid = (start + end) / 2;
        CSATreeNode root = new CSATreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    public CSATreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        CSATreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }
}
