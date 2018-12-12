class Solution {

    // my idea: get an integer from 0 to sum
    // NEW IDEA: binary search in pickIndex
    Random ran;
    int sum;
    int [] data;
    public Solution(int[] w) {
        ran = new Random();
        data = new int[w.length];

        sum = 0;
        for(int i = 0; i<w.length; i++) {
            sum += w[i];
            data[i] = sum;
        }
    }
    
    public int pickIndex() {
        int poll = ran.nextInt(sum) + 1;
        int search = Arrays.binarySearch(data, poll);
        if(search >= 0) return search;
        else return -search -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */