class Solution {
    public int maxTurbulenceSize(int[] A) {
        // 2ptrs
        if(A.length <= 1) return A.length;
        int res = 1;
        int ctr = 0;
        boolean preInc = false;
        boolean init = false;
        for(int i = 0; i<A.length-1; i++) {
            //System.out.println(i + "," + ctr + "," + res);
            if(A[i] == A[i+1]) {
                init = false;
                res = Math.max(ctr, res);
                ctr = 1;
                continue;
            }

            if(!init) {
                preInc = A[i] < A[i+1];
                ctr = 2;
                init = true;
                continue;
            }

            if(preInc && A[i] > A[i+1] || !preInc && A[i] < A[i+1]) {
                preInc = !preInc;
                ctr++;
            } else {
                init = false;
                i--;
                res = Math.max(res, ctr);
            }
        }

        res = Math.max(res, ctr);

        return res;
    }
}