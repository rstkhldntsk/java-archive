package com.leetcode.archive.easy;

import java.util.Arrays;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        var ransomN = ransomNote.toCharArray();
        var magaz = magazine.toCharArray();
        Arrays.sort(ransomN);
        Arrays.sort(magaz);
        for (int i = 0, j = 0; i < magaz.length; i++) {
            if (magaz[i] == ransomN[j]) j++;
            if (j == ransomN.length) return true;
        }
        return false;
    }

}
