class Solution {

    // idea from LC, we have to find this out for this question
    // after sort, what we need is for each c, we have to find a, b, before it that a + b > c, and at the same time maximize a + b
    public int largestPerimeter(int[] A) {
        if(A == null || A.length < 3) return 0;
        Arrays.sort(A);  
        for(int i=A.length-1; i>=2; i--) {
            if(A[i-1] + A[i-2] > A[i]) return A[i] + A[i-1] + A[i-2];
        }
        return 0;
    }


    //TLE
    // public int firstTry(int[] A) {
    //     if(A == null || A.length < 3) return 0;
    //     Arrays.sort(A);
    //     int res = 0;
    //     for(int i = 0; i<A.length; i++) {
    //         int x = A[i];
    //         for(int j=i+1; j<A.length; j++) {
    //             int y = A[j];
    //             for(int k = j+1; k<A.length && A[k] < x + y; k++) {
    //                 res = Math.max(res, x + y + A[k]);
    //             }
    //         }
    //     }

    //     return res;
    // }
}