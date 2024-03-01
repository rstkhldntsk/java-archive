package com.leetcode.archive.easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            if (price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }

}
