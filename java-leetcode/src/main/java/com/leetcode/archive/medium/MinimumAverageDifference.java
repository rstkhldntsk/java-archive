package com.leetcode.archive.medium;

public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        int res = -1;
        int minDiff = Integer.MAX_VALUE;
        long currPrefixSum = 0;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int index = 0; index < nums.length; index++) {
            currPrefixSum += nums[index];
            long leftAvg = currPrefixSum;
            leftAvg /= (index + 1);
            long rightAvg = totalSum - currPrefixSum;
            if (index != nums.length - 1) {
                rightAvg /= (nums.length - index - 1);
            }
            int currDiff = (int) Math.abs(leftAvg - rightAvg);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = index;
            }
        }
        return res;
    }
}
