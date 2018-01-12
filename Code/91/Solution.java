class Solution {
    // A message containing letters from A-Z is being encoded to numbers using the following mapping:
    //
    // 'A' -> 1
    // 'B' -> 2
    // ...
    // 'Z' -> 26
    // Given an encoded message containing digits, determine the total number of ways to decode it.
    //
    // For example,
    // Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    //
    // The number of ways decoding "12" is 2.

    // first idea dp.
    // de(s) = de(s-1)*flag1 + de(s-2)*flag2;
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        s = "0" + s;
        char [] array = s.toCharArray();
        // BUG here shoule be 1 rather than 0.
        int pre0 = 1, pre1 = 1;
        int result = 0;
        for(int i=1; i<array.length; i++) {
            result = 0;
            int code = array[i] - '0';
            // BUG here confuse with pre1 and pre0
            if(code!=0) {
                result += pre1;
            }

            code = (array[i-1] - '0') * 10 + (array[i]-'0');
            // BUG here 0 < code <= 26 is wrong
            if(array[i-1] != '0' && code <= 26) {
                result += pre0;
            }
            pre0 = pre1;
            pre1 = result;
        }
        return result;
    }

    // get from lc fastest example
    // just dp idea.
    public int fromLC(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
                dp[i] = dp[i-1];
            if (i > 1) {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
