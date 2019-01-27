class Solution {
    // TLE
    // first idea n^2
    public int subarraysDivByK(int[] A, int K) {
        int [] sum = new int [A.length];
        for(int i=0; i<A.length; i++) {
            if(i == 0) sum[i] = A[0];
            else sum[i] = sum[i-1] + A[i];
        }

        // i for length of window
        int res = 0;
        for(int i=1; i<=A.length; i++) {
            for(int j=0; j+i<=A.length; j++) {
                // inclusive
                int start = j, end = i + j - 1;
                int tar;
                if(start == 0) {
                    tar = sum[end];
                } else {
                    tar = sum[end] - sum[start - 1];
                }

                if(tar % K == 0) res++;
            }
        }
        return res;
    }
}