package dev.kotler.problemset.easy.task100;

/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

*/

import java.util.*;

// Definition for singly-linked list.
class ListNodeWithDuplicates {
    int val;
    ListNodeWithDuplicates next;

    ListNodeWithDuplicates() {
    }

    ListNodeWithDuplicates(int val) {
        this.val = val;
    }

    ListNodeWithDuplicates(int val, ListNodeWithDuplicates next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNodeWithDuplicates{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class RemoveDuplicatesFromSortedList {
    public static ListNodeWithDuplicates deleteDuplicates(ListNodeWithDuplicates head) {
        Iterable<ListNodeWithDuplicates> data = Collections.singleton(head);
        data.forEach(i -> System.out.println(i));
        return new ListNodeWithDuplicates();
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNodeWithDuplicates(1, new ListNodeWithDuplicates(2, new ListNodeWithDuplicates()))));

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,3,4));
        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println(collection);
    }
}
