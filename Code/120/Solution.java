class Solution {
    // Given a triangle, find the minimum path sum from top to bottom. Each step
    // you may move to adjacent numbers on the row below.
    //
    // For example, given the following triangle
    // [
    //      [2],
    //     [3,4],
    //    [6,5,7],
    //   [4,1,8,3]
    // ]
    // The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    //
    // Note:
    // Bonus point if you are able to do this using only O(n) extra space, where n
    // is the total number of rows in the triangle.

    // find two ideas: dfs with list, dp on rows.
    // TLE
    int min = Integer.MAX_VALUE;
    public int firstTry(List<List<Integer>> triangle) {
        dfs(triangle,0,0,0);
        return min;
    }

    public void dfs(List<List<Integer>> triangle, int row, int start, int cur){
        if(row == triangle.size()) {
            if(cur < min) min = cur;
            return;
        }
        dfs(triangle, row+1, start, cur+triangle.get(row).get(start));
        if(start+1 < triangle.get(row).size())
            dfs(triangle, row+1, start+1, cur+triangle.get(row).get(start+1));
    }

    // try dp.
    // remember the min to the place.
    public int minimumTotal(List<List<Integer>> triangle) {
        int [] board = new int[triangle.size()];
        for(int i=0; i<triangle.size(); i++) {
            for(int j=i; j>=0; j--) {
                int temp = triangle.get(i).get(j);
                int min = 0;
                if(i!=0) {
                    min = Integer.MAX_VALUE;
                    if(j<=i-1) min =  board[j];
                    if(j-1>=0) min = Math.min(min, board[j-1]);
                }
                board[j] = temp + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<board.length; i++) {
            min = Math.min(board[i], min);
        }
        return min;
    }
}
