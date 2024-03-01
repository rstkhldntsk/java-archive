package com.leetcode.archive.easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
//        first solution
//        String[] split = s.split("\\W+");
//        return split[split.length - 1].length();
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                length++;
            } else {
                if (length > 0) return length;
            }
        }
        return length;
    }

}
