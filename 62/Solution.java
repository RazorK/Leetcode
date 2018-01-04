class Solution {
    // A robot is located at the top-left corner of a m x n grid (marked 'Start'
    // in the diagram below).
    //
    // The robot can only move either down or right at any point in time. The
    // robot is trying to reach the bottom-right corner of the grid (marked 'Finish'
    // in the diagram below).
    //
    // How many possible unique paths are there?
    //
    //
    // Above is a 3 x 7 grid. How many possible unique paths are there?
    //
    // Note: m and n will be at most 100.

    // first try summary the formula, failed, just try the dfs way.
    // time limit exceed...
    public static int uniquePaths(int m, int n) {
        // BUG not 0 here, should be 1.
        if(m==1 || n==1) return 1;
        else{
            return uniquePaths(m-1, n) + uniquePaths(m, n-1);
        }
    }

    // try find the formula..
    // just m+n choose m(or n) what am I thinking..
    // overflow...
    public static int formula(int m, int n) {
        if(m<=1||n<=1) return 1;
        return (int)(fact(m+n)/(fact(m) * fact(n)));
    }

    public static long fact(int n) {
        long result = 1;
        for(int i=1; i<=n ; i++) {
            result*= i;
        }
        return result;
    }

    // try simplify
    // worked..
    public static int formula(int m, int n) {
        if(m<=1||n<=1) return 1;
        m--;n--;
        int larger = m>n? m: n;
        int smaller = m>n?n:m;
        long up = 1;
        long down = 1;
        for(int i = larger+smaller; i>=larger+1; i--) {
            up*=i;
        }
        for(int i = 1;i<=smaller ;i++) {
            down*=i;
        }
        return (int)(up/down);
    }

    // suggested
    // don't understand
    // Pascal's triangle?
    // a simplified DP solution.
    public int suggested(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);
        for ( int i = 1; i < m; i++){
            for ( int j = 1; j < n; j++){
                row[j]+=row[j-1];
            }
        }
        return row[n-1];
    }
}
