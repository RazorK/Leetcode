public class Solution {
    // Reverse bits of a given 32 bits unsigned integer.
    //
    // Example:
    //
    // Input: 43261596
    // Output: 964176192
    // Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
    //              return 964176192 represented in binary as 00111001011110000010100101000000.
    // Follow up:
    // If this function is called many times, how would you optimize it?
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = n & 1;
        for(int i=1; i<32; i++) {
            res = res << 1;
            res += (n>>i) & 1;
        }
        return res;
    }
}
