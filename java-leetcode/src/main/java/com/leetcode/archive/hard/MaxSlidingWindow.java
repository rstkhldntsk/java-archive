package com.leetcode.archive.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        // store index
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // deque contains index... result contains content
            deque.offer(i);
            if (i >= k - 1) {
                result[resultIdx++] = nums[deque.peek()];
            }
        }
        return result;
    }

}
