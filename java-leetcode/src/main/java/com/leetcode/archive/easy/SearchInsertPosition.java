package com.leetcode.archive.easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

}
