package com.leetcode.archive.easy;

import java.util.Stack;

public class QueueUsing2Stacks {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public QueueUsing2Stacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

}
