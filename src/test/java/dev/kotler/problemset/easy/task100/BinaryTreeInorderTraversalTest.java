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


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//   Definition for a binary tree node.
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(TreeNode next) {
        this.next = next;
    }

    TreeNode(Integer val) {
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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        return Stream.of(
//                Arguments.of(List.of(1, 3, 2), List.of(1, null, 2, 3)),
//                Arguments.of(List.of(1, 3, 2), new TreeNode[1]),
                Arguments.of(Arrays.asList(1, 2, 3), new TreeNode(node1))
//                Arguments.of(List.of(), new TreeNode[]{})
        );
    }

    List<Integer> listNode = new ArrayList<>();

    @ParameterizedTest
    @MethodSource("inorderTraversalArgs")
    void result(List<Integer> listData, TreeNode root) {
        var r = inorderTraversalTest(root);
        assertEquals(listData, r);
    }

    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            listNode.add(node.val);
            inorder(node.right);
        }
    }

    public List<Integer> inorderTraversalTest(TreeNode root) {
        inorder(root);
        return listNode;
    }
}
