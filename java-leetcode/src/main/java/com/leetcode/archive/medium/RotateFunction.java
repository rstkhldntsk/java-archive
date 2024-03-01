package com.leetcode.archive.medium;

public class RotateFunction {

    public int maxRotateFunction(int[] nums) {
        int allSum = 0;
        int F = 0;
        for (int i = 0; i < nums.length; i++) {
            F += i * nums[i];
            allSum += nums[i];
        }
        int max = F;
        for (int i = nums.length - 1; i >= 1; i--) {
            F = F + allSum - nums.length * nums[i];
            max = Math.max(F, max);
        }
        return max;
    }

}
