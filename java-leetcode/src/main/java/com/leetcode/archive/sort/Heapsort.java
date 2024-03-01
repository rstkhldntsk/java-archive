package com.leetcode.archive.sort;

public class Heapsort {

    public void heapsort(int[] arr) {
        int N = arr.length;
        buildMaxHeap(arr, N);
        for (int i = N - 1; i >= 0; i--) {
            swap(arr, 0, N - 1);
            N = N - 1;
            maxHeapify(arr, 0, N);
        }
    }

    public void buildMaxHeap(int[] arr, int N) {
        for (int i = N / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, N);
        }
    }

    public void maxHeapify(int[] heap, int i, int N) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest;
        if (l < N && heap[l] > heap[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < N && heap[r] > heap[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(heap, i, largest);
            maxHeapify(heap, largest, N);
        }
    }

    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

}
