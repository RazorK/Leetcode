class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int [] pre = Arrays.copyOf(costs[0], costs[0].length);
        for(int i=1; i<costs.length; i++) {
            int [] next = new int [3];
            for(int j=0; j<3; j++) {
                int cur = costs[i][j];
                int min = Integer.MAX_VALUE;
                for(int k=0; k<3; k++) {
                    if(k == j) continue;
                    min = Math.min(min, pre[k]);
                }
                next[j] = cur + min;
            }
            pre = next;
        }
        int res = Integer.MAX_VALUE;
        for(int i : pre) {
            res = Math.min(res, i);
        }
        return res;
    }
}