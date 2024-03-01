package com.leetcode.archive.utils;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var cur = this;
        while (cur != null) {
            sb.append(cur.val).append(", ");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListNode) return this.toString().equals(obj.toString());
        else return false;
    }

}
