class FromLC {

	public void solve(char[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int n = board.length;
		int m = board[0].length;

		boolean[][] visited = new boolean[n][m];

		// Just use the border of the matrix
		for (int j = 0; j < m; j++) {
			if (!visited[0][j] &&  board[0][j] == 'O') {
				dfs(0, j, visited, board);
			}
		}

		for (int j = 0; j < m; j++) {
			if (!visited[n-1][j] && board[n-1][j] == 'O') {
				dfs(n-1, j, visited, board);
			}
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i][0] &&  board[i][0] == 'O') {
				dfs(i, 0, visited, board);
			}
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i][m-1] && board[i][m-1] == 'O') {
				dfs(i, m-1, visited, board);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}else if (board[i][j] == 'S') {
					board[i][j] = 'O';
				}
			}
		}
	}

	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // NOTE: here is what we can learn from, use dirs and for loop to dfs in 4 directions.
	public void dfs(int i, int j, boolean[][] visited, char[][] board){
		visited[i][j] = true;
		board[i][j] = 'S';
		for (int[] dir: dirs) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O' || visited[x][y]) {
				continue;
			}
			dfs(x, y, visited, board);
		}
	}
}
