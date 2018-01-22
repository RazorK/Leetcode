class Solution {
    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // Design an algorithm to find the maximum profit. You may complete as many transactions as
    // you like (ie, buy one and sell one share of the stock multiple times). However, you may
    // not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

    // QUESTION: can we sell and buy at the same day.
    // assume yes.

    // Basic idea: find all the increasing part and dismiss all the decreasing part
    public int maxProfit(int[] prices) {
        int sum = 0;
        int ptr = 0;
        int low = 0;
        int ahead = Integer.MAX_VALUE;
        boolean init = false;
        while(ptr<prices.length) {
            int cur = prices[ptr];
            if(cur<ahead) {
                if(init) {
                    sum += ahead - low;
                    init = false;
                }
                low = cur;
            } else {
                // BUG here, mid put the init = true ahead.
                init = true;
            }
            ahead = cur;
            ptr++;
        }
        // BUG, here we should handle the last transaction
        if(init) {
            sum += prices[ptr-1]-low;
        }
        return sum;
    }
}
