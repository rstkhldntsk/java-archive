package com.leetcode.archive.easy;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int pivot, left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

}
