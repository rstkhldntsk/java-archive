package com.leetcode.archive.easy;

import com.leetcode.archive.utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur != null) {
                result.add(cur.val);
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return result;
    }

}
