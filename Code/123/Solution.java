import java.util.*;
class Solution {
    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // Design an algorithm to find the maximum profit. You may complete at most two transactions.
    //
    // Note:
    // You may not engage in multiple transactions at the same time (ie, you must sell the stock
    // before you buy again).

    // BUG: the problem can not just solve by selecting the largest 2 from all the posibility of the above problem.
    //  eg. 142809, in the above problem: 4-1 + 8-2 + 9-0
    //  now we have to choose 8-1 + 9-0.

    // first possible idea: divide and find the highest on both side, and compare the sum with the global maximum
    // TLE O(n^2) time. O(n) space
    public int firstTry(int[] prices) {
        int max = 0;
        for(int i = 0; i<prices.length; i++) {
            max = Math.max(max, maxProfit(prices, 0, i)+maxProfit(prices, i, prices.length-1));
        }
        return max;
    }

    public int maxProfit(int [] prices, int start, int end) {
        int sum = 0;
        int max = 0;
        int sell = Integer.MIN_VALUE;
        for(int i = end; i>=start; i--) {
            int temp = prices[i];
            if(temp>=sell) {
                sell = temp;
            }
            max = Math.max(max, sell - temp);
        }
        return max;
    }

    // try to improve.
    // use recursive idea, we can easily get the highest profit 0 to index and index to end.
    // linear time, linear space. Pass.
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int[] forward = new int[prices.length];
        int low = prices[0];
        forward[0] = 0;
        // NOTE turn out we can solve this only by tracking the lowest number.
        // find this by trying... Not figuring out how to think this up.
        for(int i=1; i<prices.length; i++) {
            int temp = prices[i];
            if(temp<low) {
                low = temp;
                forward[i] = forward[i-1];
                continue;
            }
            forward[i] = Math.max(forward[i-1], temp-low);
        }

        int [] backward = new int[prices.length];
        int high = prices[prices.length-1];
        backward[prices.length-1] = 0;
        for(int i=prices.length-2; i>=0; i--) {
            int temp = prices[i];
            if(temp>high) {
                high = temp;
                backward[i] = backward[i+1];
                continue;
            }
            backward[i] = Math.max(backward[i+1], high-temp);
        }

        int res = 0;
        for(int i=0; i<prices.length; i++) {
            res = Math.max(res, forward[i] + backward[i]);
        }
        return res;
    }

    // IDEA from LC.
    // NOTE seems useful for any number of transactions.
    // NOTE Idea of DP. 2-D DP.
    // Explanation from LC:
    // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
    // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
    //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
    // f[0, ii] = 0; 0 times transation makes 0 profit
    // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
    public int fromLC(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int K=2;
        int res= Integer.MIN_VALUE;
        int[][] dp = new int[K+1][prices.length];

        for(int kk =1; kk<=K; kk++){
            int tmp= dp[kk-1][0]-prices[0];
            for(int ii=1;ii<prices.length;ii++){
                dp[kk][ii] = Math.max(dp[kk][ii-1] ,  prices[ii]+tmp);
                tmp= Math.max(dp[kk-1][ii]-prices[ii],tmp);
                res = Math.max(res, dp[kk][ii]);
            }
        }
        return res;
    }
}
