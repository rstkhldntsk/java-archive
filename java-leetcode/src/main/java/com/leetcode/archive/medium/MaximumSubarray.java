package com.leetcode.archive.medium;

public class MaximumSubarray {

    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int end = 0;
        for (int num : nums) {
            end += num;
            if (max < end) max = end;
            if (end < 0) end = 0;
        }
        return max;
    }

}
