class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int [] res = new int[m*n];
        int ptr = 0;
        for(int i=0; i< m + n - 1; i++) {
            boolean down = i%2 == 1;
            
            if(down) {
                int y = Math.min(n-1, i);
                int x = i - y;
                while(y >= 0 && x < m) {
                    res[ptr++] = matrix[x++][y--];
                }
            } else {
                int x = Math.min(m-1, i);
                int y = i - x;
                while(x >= 0 && y < n) {
                    res[ptr++] = matrix[x--][y++];
                }
            }
        }
        return res;
    }
}