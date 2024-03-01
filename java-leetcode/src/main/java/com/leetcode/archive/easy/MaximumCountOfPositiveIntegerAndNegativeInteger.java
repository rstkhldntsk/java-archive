package com.leetcode.archive.easy;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public int maximumCount(int[] nums) {
        if (nums[0] == 0 && nums[nums.length - 1] == 0) return 0;
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;
        int neg = binarySearch(nums, 0), pos = nums.length - binarySearch(nums, 1);
        return Math.max(neg, pos);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return left;
    }

}
