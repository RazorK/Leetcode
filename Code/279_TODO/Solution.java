class Solution {

    // main idea dp. how to pass to next is the key!
    public int numSquares(int n) {
        if(isSquare(n)) return 1;
        int [] map = new int[n+1];
        map[0] = 0;
        map[1] = 1;

        for(int i=0; i<=Math.sqrt(n); i++) {
            map[i*i] = 1;
        }

        for(int i=2; i<=n; i++) {
            if(map[i]!=0) continue;
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<i; j++) {
                min = Math.min(min, map[j*j] + map[i-j*j]);
            }
            map[i] = min;
        }
        return map[n];
    }

    public boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt*sqrt == n;
    }
}