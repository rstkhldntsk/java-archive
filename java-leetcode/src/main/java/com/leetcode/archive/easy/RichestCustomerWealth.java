package com.leetcode.archive.easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for (int i = 0; i < accounts.length; i++) {
            int customerWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                customerWealth += accounts[i][j];
            }
            if (customerWealth > richest) richest = customerWealth;
        }
        return richest;
    }

}
