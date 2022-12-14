package dev.kotler.problemset.task200;

/*

https://leetcode.com/problems/symmetric-tree/

101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

*/

//Definition for a binary tree node.

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return Helper(root.left, root.right);
    }

    boolean Helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        boolean cond1 = left.val == right.val;
        boolean cond2 = Helper(left.left, right.right);
        boolean cond3 = Helper(left.right, right.left);
        return cond1 && cond2 && cond3;
    }
}
