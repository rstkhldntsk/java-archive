package com.leetcode.archive.easy;

import com.leetcode.archive.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        var curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

}
