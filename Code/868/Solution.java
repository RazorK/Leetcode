class Solution {
    public int binaryGap(int N) {
        int prev = -1;
        int res = 0;
        for(int i=0; i<32; i++) {
            if((N >> i & 1) == 1) {
                if(prev != -1) 
                    res = Math.max(i-prev, res);
                prev = i;
            }
        }
        return res;
    }
}