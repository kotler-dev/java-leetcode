package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/same-tree/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

*/

// Definition for a binary tree node.
class SameTreeNode {
    int val;
    SameTreeNode left;
    SameTreeNode right;

    SameTreeNode() {
    }

    SameTreeNode(int val) {
        this.val = val;
    }

    SameTreeNode(int val, SameTreeNode left, SameTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SameTree {
    public boolean isSameTree(SameTreeNode p, SameTreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
