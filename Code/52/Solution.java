import java.util.*;

class Solution {

    int count;
    public int totalNQueens(int n) {
        // first idea dfs && count
        if(n<=0) return 0;
        char [][] board = new char [n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], '.');
        count = 0;
        dfs(board, 0, new boolean[n], new boolean [n], new HashSet<Integer>(), new HashSet<>());
        return count;
    }

    public void dfs(char [][] board, int x, boolean [] row, boolean [] col, Set<Integer> inc, Set<Integer> dec) {
        if(x == board.length) {
            count++;
            // System.out.println(Arrays.deepToString(board));
            return;
        }
        
        for(int i=0; i<board.length; i++) {
            if(board[x][i] == '.' && check(x, i, row, col, inc, dec)) {
                board[x][i] = 'N';
                // Improvement: here we don't need to create new data structures, because we can reverse the change by simply reversing the operation
                // because it is one to one relationship
                row[x] = true; col[i] = true; inc.add(x-i); dec.add(x+i);
                dfs(board, x+1, row, col, inc, dec);
                row[x] = false; col[i] = false; inc.remove(x-i); dec.remove(x+i);
                board[x][i] = '.';
            }
        }
    }

    public boolean check(int x, int y, boolean [] row, boolean [] col, Set<Integer> inc, Set<Integer> dec) {
        if(row[x] || col[y]) return false;
        if(inc.contains(x-y)) return false;
        if(dec.contains(x+y)) return false;
        return true;
    }
}