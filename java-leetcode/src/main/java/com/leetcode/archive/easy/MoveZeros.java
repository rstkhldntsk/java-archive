package com.leetcode.archive.easy;

public class MoveZeros {

    /**
     * This solution uses two pointers,
     * one to keep track of the position of the next non-zero element,
     * and the other to iterate through the array.
     * It first iterates through the array and whenever it encounters a non-zero element,
     * it places it at the position of the next non-zero element and increments the index of the next non-zero element.
     * After the first iteration, all non-zero elements are moved to the beginning of the array
     * and all remaining elements are zeroes.
     */
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

}
