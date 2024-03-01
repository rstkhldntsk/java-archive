package com.leetcode.archive.medium;

public class FirstLastPosition {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] >= target) right = pivot - 1;
            else left = pivot + 1;
            if (nums[pivot] == target) idx = pivot;
        }
        return idx;
    }

    public int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] <= target) left = pivot + 1;
            else right = pivot - 1;
            if (nums[pivot] == target) idx = pivot;
        }
        return idx;
    }

}
