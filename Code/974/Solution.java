class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //get the idea from LC, is this medium difficulty??

        // linear
        // key 1: prefix sum
        // key 2: (x - y) % k == 0 <=> x%k == y%k
        // key 3: like what we do when we count rects, use n choose 2 rather than count all the connection
        int [] sum = new int [A.length];
        sum[0] = A[0];
        for(int i=1; i<sum.length; i++) {
            sum[i] = A[i] + sum[i-1];
        }

        int [] count = new int[K];
        // two bugs here
        // BUG1 : we have to add count[0], because the start point can be set as 0
        // BUG2 : what if some value in sum is neg, here I learn the trick: (s % K + K) % K
        for(int s : sum) {
            count[(s % K + K) % K]++;
        }
        count[0] ++;

        int res = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] >= 2) res += count[i] * (count[i] - 1) /2;
        }
        return res;
    }
} 