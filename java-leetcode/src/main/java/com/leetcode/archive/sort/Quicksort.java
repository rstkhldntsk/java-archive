package com.leetcode.archive.sort;

public class Quicksort {

    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int first, int last) {
        if (first < last) {
            int q = partition(arr, first, last); // get the index of the sorted pivot
            quicksort(arr, first, q - 1);
            quicksort(arr, q + 1, last);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }

}
