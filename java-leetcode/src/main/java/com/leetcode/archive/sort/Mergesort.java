package com.leetcode.archive.sort;

public class Mergesort {

    public int[] mergesort(int[] arr) {
        if (arr == null) return null;
        if (arr.length < 2) return arr;

        var left = new int[arr.length / 2];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        var right = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - arr.length / 2);

        left = mergesort(left);
        right = mergesort(right);

        return merge(left, right);
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
