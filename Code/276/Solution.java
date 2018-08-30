class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        int first = k;
        int second = 0;

        for(int i=1; i<n; i++) {
            int tempSec = second;
            int tempFirs = first;
            second = first;
            first = (k-1) * (tempSec + tempFirs);
        }

        return first + second;
    }
}