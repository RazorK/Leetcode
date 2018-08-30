class Solution {

    // find the first one that y - (n-i) > 0
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int length = citations.length;
        int left = 0, right = length - 1;
        if((citations[right] - (length - right)) < 0) return 0;
        while(left <= right) {
            if(left == right) return length-left;
            int mid = left + (right - left)/2;
            int cur = citations[mid];
            if(cur - (length-mid) >= 0) {
                right =  mid;
            } else {
                left = mid+1;
            }
        }
        return 0;
    }
}