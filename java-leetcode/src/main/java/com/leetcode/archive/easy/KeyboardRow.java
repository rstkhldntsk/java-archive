package com.leetcode.archive.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (containsAllLetters(word, "qwertyuiop") || containsAllLetters(word, "asdfghjkl") || containsAllLetters(word, "zxcvbnm")) {
                res.add(word);
            }
        }
        return fillArray(res);
    }

    private String[] fillArray(List<String> res) {
        var result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private boolean containsAllLetters(String word1, String word2) {
        char[] secondWordChars = word2.toLowerCase().toCharArray();
        Arrays.sort(secondWordChars);
        for (char c : word1.toLowerCase().toCharArray()) {
            int index = Arrays.binarySearch(secondWordChars, c);
            if (index < 0) {
                return false;
            }
        }
        return true;
    }

}
