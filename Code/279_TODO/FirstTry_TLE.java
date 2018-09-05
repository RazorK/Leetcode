class Solution {

    // TLE..
    public int numSquares(int n) {
        if(isSquare(n)) return 1;
        int [] map = new int [n];
        Arrays.fill(map, -1);
        for(int i=1; i< Math.sqrt(n); i++) {
            map[i*i] = 1;
        }

        return numSquares(n, map);
    }

    public int numSquares(int n, int [] map) {
        if(n<map.length && map[n] != -1) return map[n];
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n/2; i++) {
            int first = numSquares(i, map);
            int second = numSquares(n-i, map);
            min = Math.min(first + second, min);
        }
        if(n<map.length) map[n] = min;
        return min;
    }

    public boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}