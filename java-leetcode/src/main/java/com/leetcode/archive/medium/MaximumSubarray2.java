package com.leetcode.archive.medium;

public class MaximumSubarray2 {

    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    public int[] maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int end = 0, startIdx = 0, endIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            end += nums[i];
            if (max < end) {
                max = end;
                endIdx = i;
            }
            if (end < 0) {
                end = 0;
                startIdx = i + 1;
            }
        }
        var result = new int[endIdx - startIdx + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[startIdx++];
        }

        return result;
    }

}
