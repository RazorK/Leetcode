class Solution {
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0) return A;
        int left = 0, right = A.length-1;
        int [] res = new int [A.length];
        int ptr = res.length-1;
        while(left <= right) {
            int ll = A[left], rr = A[right];
            if(ll*ll > rr * rr) {
                res[ptr--] = ll*ll;
                left++;
            } else {
                res[ptr--] = rr * rr;
                right--;
            }
        }
        return res;
    }
}