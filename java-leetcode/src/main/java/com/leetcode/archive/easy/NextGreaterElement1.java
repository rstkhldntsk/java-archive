package com.leetcode.archive.easy;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextElement(nums2, nums1[i]);
        }
        return result;
    }

    private int nextElement(int[] nums, int element) {
        boolean started = false;
        for (int num : nums) {
            if (num == element) started = true;
            if (started && num > element) {
                return num;
            }
        }
        return -1;
    }

}
