package com.leetcode.archive.easy;

import com.leetcode.archive.utils.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        var curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                if (curr.next.next != null) curr.next = curr.next.next;
                else curr.next = null;
            }
            curr = curr.next;
        }
        return head;
    }

}
