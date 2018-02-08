class Review {
    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    public int maxProfit(int[] prices) {
        // think of this problem in a bar chart
        // we have to take advantage of all the incresing part.
        if(prices == null || prices.length<=1) return 0;
        int sum = 0;
        int buy = prices[0];
        int sell = buy;
        for(int i=1; i<prices.length; i++) {
            int temp = prices[i];
            if(temp < sell) {
                sum += sell - buy;
                buy = temp;
                sell = temp;
            } else {
                sell = temp;
            }
        }
        // BUG here, we didn't solve the last problem.
        sum += sell -buy;
        return sum;
    }
}
