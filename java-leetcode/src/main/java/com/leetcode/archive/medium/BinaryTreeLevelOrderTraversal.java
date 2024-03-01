package com.leetcode.archive.medium;

import com.leetcode.archive.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null) return wrapList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int lvl = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < lvl; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    subList.add(cur.val);
                }
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

}
