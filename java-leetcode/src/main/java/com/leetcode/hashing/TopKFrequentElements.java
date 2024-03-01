package com.leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 347. Top K Frequent Elements(medium)
 * <p>
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        var elementList = new ArrayList<Element>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            elementList.add(new Element(entry.getKey(), entry.getValue()));
        }
        elementList.sort((e1, e2) -> e2.freq - e1.freq);
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elementList.get(i).value;
        }
        return result;
    }

}

class Element {

    int value;
    int freq;

    public Element(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }

}
