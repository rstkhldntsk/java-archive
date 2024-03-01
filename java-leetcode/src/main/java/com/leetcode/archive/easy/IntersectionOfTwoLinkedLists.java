package com.leetcode.archive.easy;

import com.leetcode.archive.utils.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        //if currA & currB have different len, then we will stop the loop after second iteration
        while (currA != currB) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
//        Set<Integer> set = new HashSet<>();
//        while (headA != null) {
//            set.add(headA.hashCode());
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (!set.add(headB.hashCode())) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
    }

}
