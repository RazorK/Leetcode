import java.util.Set;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> res = new HashSet<>();
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, 's');
                res.add(sb.toString());
            }
        }
        return res.size();
    }

    public void dfs(int [][] grid, int i, int j, StringBuilder sb, char direction) {
        if(i < 0 || i>=grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == 0) return;
        sb.append(direction);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, 'l');
        dfs(grid, i+1, j, sb, 'r');
        dfs(grid, i, j-1, sb, 'u');
        dfs(grid, i, j+1, sb, 'd');
        sb.append(reverseDirection(direction));
    }

    public static char reverseDirection(char direciton) {
        switch(direciton) {
            case 'l': return 'r';
            case 'r': return 'l';
            case 'u': return 'd';
            case 'd': return 'u';
            default:
                return '0';
        }
    }
}