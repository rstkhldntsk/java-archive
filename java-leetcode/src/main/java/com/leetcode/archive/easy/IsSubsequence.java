package com.leetcode.archive.easy;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int sIdx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sIdx) == t.charAt(i)) {
                sIdx++;
                if (sIdx >= s.length()) return true;
            }
        }
        return false;
    }

}
