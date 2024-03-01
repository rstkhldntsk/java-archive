package com.leetcode.hashing;

import java.util.HashSet;

/**
 * 217. Contains Duplicate(easy)
 * <p>
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }

        return false;
    }

}
