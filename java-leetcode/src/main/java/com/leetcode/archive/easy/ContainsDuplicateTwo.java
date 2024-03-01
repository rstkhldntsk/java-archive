package com.leetcode.archive.easy;

public class ContainsDuplicateTwo {

    /**
     * This solution uses a sliding window approach,
     * where a set is used to store the elements in the current window of size k.
     * The elements in the window are added to the set, and if a duplicate is encountered,
     * the function returns true.
     * If the end of the array is reached and no duplicates were found, the function returns false.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length || j - i < k; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
