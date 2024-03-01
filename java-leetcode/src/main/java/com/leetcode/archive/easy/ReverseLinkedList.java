package com.leetcode.archive.easy;

import com.leetcode.archive.utils.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        if (head.next == null) return head;
//        var second = head.next;
//        var rest = reverseList(second);
//        second.next = head;
//        head.next = null;
//        return rest;
//    }

}
