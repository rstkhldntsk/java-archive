package com.leetcode.archive.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] indexes = new int[2];
        if (numbers == null || numbers.length < 2) return indexes;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indexes[0] = left + 1;
                indexes[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return indexes;
    }

}
