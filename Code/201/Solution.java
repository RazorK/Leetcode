class Solution {
    // Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
    //
    // Example 1:
    //
    // Input: [5,7]
    // Output: 4
    // Example 2:
    //
    // Input: [0,1]
    // Output: 0

    // IDEA keep the same bits m and n have at head. fill the rest with 0.
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int res = 0;
        boolean flag = false;
        for(int i=31; i>=0; i--) {
            res = res<<1;
            if(!flag && (m>>i & 1) == (n>>i & 1)) {
                res += (m>>i & 1);
            } else {
                flag = true;
            }
        }
        return res;
    }
}
