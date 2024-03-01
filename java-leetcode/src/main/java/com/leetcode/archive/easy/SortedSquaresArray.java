package com.leetcode.archive.easy;

import java.util.Arrays;

public class SortedSquaresArray {

    public static void main(String[] args) {
        int[] squares = sortedSquares(new int[]{-6, -3, 2, 4, 5, 7});
        System.out.println(Arrays.toString(squares));
    }

    public static int[] sortedSquares(int[] nums) {
        var sq = new int[nums.length];
        int right = nums.length - 1;
        int left = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > nums[right]) {
                sq[i] = nums[left] * nums[left];
                left++;
            } else {
                sq[i] = nums[right] * nums[right];
                right--;
            }
        }
        return sq;
    }

}
