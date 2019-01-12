class Solution {
    public int countCornerRectangles(int[][] grid) {
        // complexity M * N ^ 2
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        List<Set<Integer>> mem = new ArrayList<>();
        int res = 0;
        for(int i=0; i<m; i++) {
            Set<Integer> cur = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) continue;
                cur.add(j);
            }

            for(Set<Integer> pre : mem) {
                int count = 0;
                for(int one : cur) {
                    if(pre.contains(one)) count++;
                }
                if(count >=2) res+= count * (count - 1) / 2;
            }
            mem.add(cur);
        }

        return res;
    }
}