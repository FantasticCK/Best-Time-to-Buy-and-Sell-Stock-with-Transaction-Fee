package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[] buy = new int[n + 1], sell = new int[n + 1];
        buy[1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            int price = prices[i - 1];
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price - fee);
        }
        return sell[n];
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}