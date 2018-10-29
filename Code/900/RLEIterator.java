class RLEIterator {

    int [] data;
    int ptr;
    public RLEIterator(int[] A) {
        data = A;
        ptr = 0;
    }
    
    public int next(int n) {
        while(n > 0) {
            if(ptr >= data.length) return -1;
            int cur = data[ptr];
            // BUG 1 : equal here.
            if(cur >= n) {
                data[ptr] = cur - n;
                // BUG2: index here
                return data[ptr+1];
            } else {
                n-= cur;
                ptr+=2;
            }
        }
        return 0;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */