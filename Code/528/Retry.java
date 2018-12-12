class Solution {
    int [] sum;
    Random ran;
    public Solution(int[] w) {
        // idea accumulative sum
        ran = new Random();
        sum = new int [w.length];
        for(int i=0; i<w.length; i++) {
            sum[i] = i==0? w[i] : sum[i-1] + w[i];
        }
    }
    
    public int pickIndexWithBS() {
        int x = ran.nextInt(sum[sum.length-1]) + 1;
        int index = Arrays.binarySearch(sum, x);
        return index >= 0 ? index : -index - 1;
    }

    public int pickIndex() {
        int x = ran.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length-1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(x == sum[mid]) return mid;
            if(x > sum[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */