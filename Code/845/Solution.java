class Solution {
    public int longestMountain(int[] A) {
        // my first idea state machine
        boolean increase = true;
        int cur = 0;
        int max = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i] > A[i-1]) {
                if(increase) cur++;
                else {
                    max = Math.max(max, cur);
                    cur = 1;
                    increase = true;
                }
            } else if(A[i] < A[i-1]) {
                if(!increase) cur++;
                else {
                    if(cur == 0) continue;
                    cur++;
                    increase = false;
                }
            } else {
                if(!increase) max = Math.max(max, cur);
                cur = 0;
                increase = true;
            }
        }
        if(!increase) max = Math.max(max, cur);
        return max == 0? max : max+1;
    }
}