package com.leetcode.archive.easy;

import com.leetcode.archive.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        if (current != null) stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(0, current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return result;
    }

    /* public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }
        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) return;
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);
        }
     */
}
