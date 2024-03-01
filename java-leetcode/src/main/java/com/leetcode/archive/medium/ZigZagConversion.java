package com.leetcode.archive.medium;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
        String convert = convert("PAYPALISHIRING", 4);
        System.out.println(convert.equals("PINALSIGYAHRPI"));
    }

    /**
     * [00]P                      [06]I                      [12]N
     * [01]A             [05]L    [07]S             [11]I    [13]G
     * [02]Y    [04]A             [08]H    [10]R
     * [03]P                      [09]I
     */

    public static String convert(String s, int numRows) {
        int step = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) {
                    sb.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return sb.toString();
    }

}
