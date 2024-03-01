package com.leetcode.archive.hard;

public class MedianTwoArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        if (merged.length % 2 != 0) {
            return merged[merged.length / 2];
        } else {
            return (double) (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2;
        }
    }

    public int[] merge(int[] left, int[] right) {
        var res = new int[left.length + right.length];
        int leftIt = 0;
        int rightIt = 0;
        for (int i = 0; i < res.length; i++) {
            if (leftIt > left.length - 1) {
                res[i] = right[rightIt++];
            } else if (rightIt > right.length - 1) {
                res[i] = left[leftIt++];
            } else if (left[leftIt] < right[rightIt]) {
                res[i] = left[leftIt++];
            } else {
                res[i] = right[rightIt++];
            }
        }
        return res;
    }

}
