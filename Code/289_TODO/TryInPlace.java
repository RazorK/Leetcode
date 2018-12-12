class Solution {
    //define 0 dead -> dead, 1 life -> life, 2 dead -> life 3. life -> dead
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 0) {
                    if(getNum(board, i, j) == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    int cur = getNum(board, i, j);
                    if(cur<2 || cur>3) board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int cur = board[i][j];
                if(cur == 0 || cur == 1) continue;
                if(cur == 2) board[i][j] = 1;
                if(cur == 3) board[i][j] = 0;
            }
        }
    }

    public int getNum(int [][] board, int x, int y) {
        int[] list = new int[] {-1, 0, 1};
        int count = 0;
        for(int i : list) {
            for(int j: list ) {
                if(i==0 && j==0) continue;
                int newX = x+i, newY = y+j;
                if(newX<0 || newX >= board.length || newY<0 || newY >= board[0].length) continue;
                if(board[newX][newY]%2 == 1) count++;
            }
        }
        return count;
    }
}