package com.leetcode.archive.easy;

import com.leetcode.archive.utils.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        // meet the requirement of minimum's depth of binary tree
        if (root.left == null) return right;
        if (root.right == null) return left;
        return Math.max(left, right);

    }
}
