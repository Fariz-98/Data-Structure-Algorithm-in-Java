package study.java.datastructure.algo.leetcode.leetcode50;

// 121
// Easy
// Note: Go through the loop once, if the price is less than min, set the min to current price, else, calculate
// current price - min because you always have to sell the day after you bought.

import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {2,1,4};
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices3 = {3, 4, 3, 2, 1, 6, 7, 13, 1};
        System.out.println(maxProfit(prices1));
    }

    public static int maxProfit(int[] prices) {
        int currentBought = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currentBought) {
                currentBought = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - currentBought);
            }
        }
        return profit;
    }

}
