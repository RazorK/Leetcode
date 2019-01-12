import java.util.*;
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return true;
        int m = matrix.length, n = matrix[0].length;
        List<int []> start = new ArrayList<>();

        for(int i=0; i<m; i++) {start.add(new int [] {i, 0});}
        for(int i=1; i<n; i++) {start.add(new int [] {0, i});}

        for(int [] s : start) {
            int x = s[0], y = s[1];
            int tar = matrix[x][y];
            while(++x < m && ++y < n) {
                if(matrix[x][y]!=tar) return false;
            }
        }

        return true;
    }
}