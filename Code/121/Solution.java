class Solution {
    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    //
    // Example 1:
    // Input: [7, 1, 5, 3, 6, 4]
    // Output: 5
    //
    // max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
    // Example 2:
    // Input: [7, 6, 4, 3, 1]
    // Output: 0
    //
    // In this case, no transaction is done, i.e. max profit = 0.

    // first idea n^2
    // TLE
    public int firstTry(int[] prices) {
        int min = 0;
        for(int i=0; i<prices.length -1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                min = Math.max(min, prices[j]-prices[i]);
            }
        }
        return min;
    }

    // NOTE for this problem, what we want is actually, for each item, what's the maximum item after it.
    // Try Linear Solution
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i=prices.length-1; i>=0; i--) {
            max = Math.max(max, prices[i]);
            prices[i] = max - prices[i];
            res = Math.max(prices[i], res);
        }
        return res;
    }
}
