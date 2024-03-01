package com.leetcode.archive.easy;

public class ReverseString {

    public char[] reverseString(char[] s) {
//        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
//            char tmp = s[i];
//            s[i] = s[j];
//            s[j] = tmp;
//        }
//        return s;
        int start = 0, end = s.length - 1;
        while (start <= end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        return s;
    }

}
