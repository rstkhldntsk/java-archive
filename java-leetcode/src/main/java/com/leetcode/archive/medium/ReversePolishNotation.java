package com.leetcode.archive.medium;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        for (String s : tokens) {
            if ("+".equals(s)) stack.push(stack.pop() + stack.pop());
            else if ("-".equals(s)) stack.push(-stack.pop() + stack.pop());
            else if ("/".equals(s)) stack.push((int) (1D / stack.pop() * stack.pop()));
            else if ("*".equals(s)) stack.push(stack.pop() * stack.pop());
            else stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }
}
