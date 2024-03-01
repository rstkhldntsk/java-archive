package com.leetcode.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams(medium)
 * <p>
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        var hash = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            var word = new String(charArray);
            if (!hash.containsKey(word)) {
                hash.put(word, new ArrayList<>());
            }
            hash.get(word).add(str);
        }
        return new ArrayList<>(hash.values());
    }

}
