package com.leetcode.hashing;

import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence(medium)
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSeq = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int length=0;
                while (set.contains(num + length)) {
                    length++;
                }
                if (length > maxSeq) {
                    maxSeq = length;
                }
            }
        }
        return maxSeq;
    }

}
