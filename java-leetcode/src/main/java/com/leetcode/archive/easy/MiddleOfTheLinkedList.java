package com.leetcode.archive.easy;

import com.leetcode.archive.utils.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode mid = head, fast = head;
        int step = 0;
        while (fast != null) {
            if (step % 2 == 0 && fast.next != null) mid = mid.next;
            step++;
            fast = fast.next;
        }
        return mid;
    }

}
