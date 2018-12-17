import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] grid) {
        // bfs from 0 to 1 or from 1 to 0
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int [][] sum = new int [m][n];
        int [][] count = new int[m][n];

        int numOfOne = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int cur = grid[i][j];
                if(cur == 1) {
                    bfs(grid, sum, i, j, count);
                    numOfOne++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0 && count[i][j] == numOfOne) {
                    min = Math.min(min, sum[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs(int [][] grid, int [][] sum, int i, int j, int [][] count) {
        if(grid[i][j] != 1) return;
        Queue<int []> q = new LinkedList<int []>();
        Set<String> visited = new HashSet<>();
        Set<String> inQ = new HashSet<>();

        int curStep = 0;
        int curLength = 1;
        q.add(new int[]{i, j});

        while(q.size()!=0) {
            int [] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(visited.contains(x + "," + y)) continue;

            if(grid[x][y] == 0) {
                sum[x][y]+=curStep;
                count[x][y] ++;
            }

            visited.add(x + "," + y);

            // add  nodes in queue
            // if(x-1 >= 0 && grid[x-1][y] == 0 ) q.add(new int[] {x-1, y});
            // if(x+1 < grid.length && grid[x+1][y] == 0) q.add(new int [] {x+1, y});
            // if(y-1 >=0 && grid[x][y-1] == 0) q.add(new int[] {x, y-1});
            // if(y+1 < grid[0].length && grid[x][y+1] == 0) q.add(new int [] {x, y+1});
            helper(grid, x-1, y, inQ, q);
            helper(grid, x+1, y, inQ, q);
            helper(grid, x, y-1, inQ, q);
            helper(grid, x, y+1, inQ, q);
            if(--curLength == 0) {
                curLength = q.size();
                curStep++;
            }
        }
    }

    public void helper(int [][] grid, int x, int y, Set<String> inQ, Queue<int []> q) {
        if(x >= 0 && x < grid.length && y>=0 && y<grid[0].length && grid[x][y] == 0 && !inQ.contains(x + "," + y)) {
            q.add(new int [] {x, y});
            inQ.add(x + "," + y);
        }
    }

} 