package com.leetcode.archive.medium;

import com.leetcode.archive.utils.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int step = 0;
        while (fast != null) {
            if (step > n) slow = slow.next;
            step++;
            fast = fast.next;
        }
        // if is needed only for case when list contains only one node
        if (step == n) {
            head = head.next;
            return head;
        }
        slow.next = slow.next.next;
        return head;
    }

}
