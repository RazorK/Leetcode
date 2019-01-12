class Solution {
    public int removeStones(int[][] stones) {
        // try dfs... make wrong
        if(stones == null || stones.length == 0 || stones[0].length == 0) {
            return 0;
        }
        int m = stones.length, n = stones[0].length;
        int res = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int cur = stones[i][j];
                if(cur == 1) {
                    int remove = dfs(stones, i, j)-1;
                    res += remove;
                }
            }
        }
        return res;
    }

    public int dfs(int [][] stones, int i, int j) {
        if(i < 0 || i >= stones.length || j<0 || j>=stones[0].length) return 0;
        if(stones[i][j] != 1) return 0;
        stones[i][j] = -1;
        int [] shifted = new int[] {-1, 0, 1, 0, -1};
        int res = 1;
        for(int k=0; k<4; k++) {
            res += dfs(stones, i + shifted[k], j + shifted[k+1]);
        }
        return res;
    }
}