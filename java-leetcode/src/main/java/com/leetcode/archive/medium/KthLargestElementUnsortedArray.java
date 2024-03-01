package com.leetcode.archive.medium;

import java.util.PriorityQueue;

public class KthLargestElementUnsortedArray {

    /**
     * Quick select
     * public int findKthLargest(int[] nums, int k) {
     *         int start = 0, end = nums.length - 1, index = nums.length - k;
     *         while (start < end) {
     *             int pivot = partion(nums, start, end);
     *             if (pivot < index) start = pivot + 1;
     *             else if (pivot > index) end = pivot - 1;
     *             else return nums[pivot];
     *         }
     *         return nums[start];
     *     }
     *
     *     private int partion(int[] nums, int start, int end) {
     *         int pivot = start, temp;
     *         while (start <= end) {
     *             while (start <= end && nums[start] <= nums[pivot]) start++;
     *             while (start <= end && nums[end] > nums[pivot]) end--;
     *             if (start > end) break;
     *             temp = nums[start];
     *             nums[start] = nums[end];
     *             nums[end] = temp;
     *         }
     *         temp = nums[end];
     *         nums[end] = nums[pivot];
     *         nums[pivot] = temp;
     *         return end;
     *     }
     */

    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.remove();
        }
        return minHeap.remove();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{7, 1, 0, 5, 6, 3}, 3));
    }

}
