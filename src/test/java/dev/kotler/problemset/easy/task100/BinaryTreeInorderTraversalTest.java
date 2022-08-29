package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/

94. Binary Tree Inorder Traversal

Given the root of a binary tree, return inorder traversal of its nodes values.

Example 1:
node 1 -> node 2 -> node 3

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
- 100 <= Node.val <= 100

*/


import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//   Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversalTest {

    public Stream<Arguments> inorderTraversalArgs() {
        return Stream.of(
                Arguments.of("[1,3,2]", new int[]{})
        );
    }

    public List<Integer> inorderTraversalTest(TreeNode root) {
        return new ArrayList<>();
    }
}
