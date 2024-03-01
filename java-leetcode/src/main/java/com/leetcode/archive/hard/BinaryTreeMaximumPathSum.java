package com.leetcode.archive.hard;

import com.leetcode.archive.utils.TreeNode;

public class BinaryTreeMaximumPathSum {

    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode currentRoot) {
        if (currentRoot == null) return 0;
        var leftMax = dfs(currentRoot.left);
        var rightMax = dfs(currentRoot.right);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        res = Math.max(res, leftMax + rightMax + currentRoot.val);
        return Math.max(leftMax, rightMax) + currentRoot.val;
    }

}
