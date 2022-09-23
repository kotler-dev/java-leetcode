package dev.kotler.problemset.task100;

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

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversalTest {

    static TreeNode root = new TreeNode();
    List<Integer> listNode = new ArrayList<>();
    static int size = 0;

    public static Stream<Arguments> inorderTraversalArgs() {
        List<Integer> nodes1 = new ArrayList<>();
        nodes1.add(1);
        nodes1.add(null);
        nodes1.add(2);
        nodes1.add(3);

        List<Integer> nodes2 = new ArrayList<>();
        nodes2.add(1);

        List<Integer> nodes3 = new ArrayList<>();
        nodes3.add(null);

        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), initTreeNode(nodes1)),
                Arguments.of(List.of(1), initTreeNode(nodes2)),
                Arguments.of(nodes3, initTreeNode(nodes3))
        );
    }


    @ParameterizedTest
    @MethodSource("inorderTraversalArgs")
    void result(List<Integer> listData, TreeNode m) {
        var r = inorderTraversalTest(m);
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

    public static TreeNode initTreeNode(List<Integer> nodes) {
        root = new TreeNode();

        for (Integer node : nodes) {
            insert(node);
        }
        return root;
    }

    static TreeNode node;

    public static void insert(Integer elem) {
        if (elem == null) {
            return;
        }
        if (root.val == null) {
            root = new TreeNode(elem);
            node = root;
            return;
        }

        while (true) {
            if (elem > 0) {
                if (node.right == null) {
                    node.right = new TreeNode(elem);
                    size++;
                    break;
                } else {
                    node = node.right;
                }
            } else if (node.val == 0) {
                return;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(elem);
                    size++;
                    break;
                } else {
                    node = node.left;
                }
            }
        }
    }
}
