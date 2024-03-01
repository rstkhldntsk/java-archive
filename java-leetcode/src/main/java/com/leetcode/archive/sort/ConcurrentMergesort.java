package com.leetcode.archive.sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ConcurrentMergesort extends RecursiveAction {

    private final int[] arr;

    public ConcurrentMergesort(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected void compute() {
        if (arr.length == 1) return;

        var left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        var right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        var leftTask = new ConcurrentMergesort(left);
        var rightTask = new ConcurrentMergesort(right);
        leftTask.fork();
        rightTask.compute();
        leftTask.join();
        merge(left, right, this.arr);
    }

    public void merge(int[] left, int[] right, int[] arr) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (l > left.length - 1) {
                arr[i] = right[r++];
            } else if (r > right.length - 1) {
                arr[i] = left[l++];
            } else if (left[l] < right[r]) {
                arr[i] = left[l++];
            } else {
                arr[i] = right[r++];
            }
        }
    }

}
