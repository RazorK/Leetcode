class Solution {

    // BUG:
    // 1. how to find the two minimum nums in an array..  remember to move min to sec_min
    // 2. what if  costs[0].length == 1? if there are multiple houses, return 0, if there's only one house, return that value.
    
    public int minCostII(int[][] costs) {
        // first idea DP same idea as before..
        if(costs == null || costs.length == 0) return 0;
        if(costs[0].length <= 1) return costs.length == 1? costs[0][0] : 0;

        int [] pre = Arrays.copyOf(costs[0], costs[0].length);

        for(int i=1; i<costs.length; i++) {
            // spend n time to find min & second min
            int min = Integer.MAX_VALUE, sec_min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0; j<pre.length; j++) { 
                int cur = pre[j];
                if(cur < min) {
                    sec_min = min;
                    min = cur;
                    minIndex = j;
                } else if(cur < sec_min) {
                    sec_min = cur;
                }
            }
            // update next
            int [] next = new int[pre.length];
            for(int j=0; j<next.length; j++) {
                if( j== minIndex) {
                    next[j] =  costs[i][j] + sec_min;
                } else {
                    next[j] = costs[i][j] + min;
                }
            }
            pre = next;
        }

        int res = Integer.MAX_VALUE;
        for(int cur : pre){
            res = Math.min(cur, res);
        }
        return res;
    }
}