package com.leetcode.archive.easy;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                intersection.add(i);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int n : intersection) {
            result[i++] = n;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
