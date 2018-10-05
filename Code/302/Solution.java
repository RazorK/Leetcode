class Solution {
    //dfs find global
    int maxX, minX, maxY, minY;
    public int minArea(char[][] image, int x, int y) {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        dfs(image, x, y);
        return (maxX-minX + 1) * (maxY-minY + 1);
    }

    public void dfs(char [][] image, int x, int y) {
        if(x<0 || x>=image.length || y<0 || y>=image[0].length) return;
        char cur = image[x][y];
        if(cur == '1') {
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);

            image[x][y] = '0';

            dfs(image, x-1, y);
            dfs(image, x+1, y);
            dfs(image, x, y-1);
            dfs(image, x, y+1);
        }
    }
}