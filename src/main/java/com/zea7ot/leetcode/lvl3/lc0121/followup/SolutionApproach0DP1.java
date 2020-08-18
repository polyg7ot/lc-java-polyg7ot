/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *  
 * how about sell short?
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0121.followup;

public class SolutionApproach0DP1 {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price : prices) {
            maxPrice = Math.max(maxPrice, price);
            maxProfit = Math.max(maxProfit, maxPrice - price);
        }

        return maxProfit;
    }
}