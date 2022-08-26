package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/merge-two-sorted-lists

21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

*/

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + val + ", " + next + "]";
    }
}

class MergeTwoSortedListsTest {
    private static Stream<Arguments> mergeTwoListsTest() {
        return Stream.of(
                Arguments.of(
                        "[1, [1, [2, [3, [4, [4, null]]]]]]",
                        new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4)))
                ),
                Arguments.of(
                        "[0, [0, null]]",
                        new ListNode(),
                        new ListNode()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("mergeTwoListsTest")
    void isMergeTwoListsTest(String listNode, ListNode list1, ListNode list2) {
        ListNode node = mergeTwoLists(list1, list2);
        assertEquals(listNode, node.toString());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                node.next = p1;
                p1 = p1.next;
            } else {
                node.next = p2;
                p2 = p2.next;
            }
            node = node.next;
        }

        if (p1 != null) {
            node.next = p1;
        }

        if (p2 != null) {
            node.next = p2;
        }

        return head.next;
    }
}