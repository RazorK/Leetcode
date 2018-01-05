class Solution {
    // Implement int sqrt(int x).
    //
    // Compute and return the square root of x.
    //
    // x is guaranteed to be a non-negative integer.
    //
    //
    // Example 1:
    //
    // Input: 4
    // Output: 2
    // Example 2:
    //
    // Input: 8
    // Output: 2
    // Explanation: The square root of 8 is 2.82842..., and since we want to return
    // an integer, the decimal part will be truncated.

    // linear try.
    // BUG overstep problem.
    // NOTE: if the result of multiply overstep, it will turn to negative.
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int i = 1;
        while(true) {
            if(i*i<0) return i-1;
            // BUG should be <= rather than <. the equal problem.
            if(i*i<=x) i++;
            else return i-1;
        }
    }

    // try binary search
    // very hard to process overstep problem
    // maybe I should try long type..
    // !!abandoned!!
    public static int binary(int x) {
        if(x == 0) return 0;
        int left = 1, right = x;
        while(true) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            System.out.println(left + ", "+right);
            if(mid * mid<x && (mid+1) * (mid+1) > x) return mid;
            if(mid == 46340 && mid*mid<x ) return mid;
            // BUG the mid is so large that although the mid^2 is overstep, it
            // is also positive.
            // BUG the mid*mid == x must
            if(mid*mid == x) return mid;
            if(mid >= 46341 || (mid * mid > x)) {
                right = mid;
                continue;
            } else if(mid * mid < x) {
                // BUG can not judge (mid+1)(mid+1) here, because this
                // may cause the mid+1 ^ 2 = x forever loop
                left = mid;
                continue;
            }
        }
    }

    // try use long rather than int...
    // pass, but still very slow???
    public static int tryLong(int x) {
        if(x == 0) return 0;
        long left = 1, right = x;
        while(true) {
            long mid = (left + right) / 2;
            if(mid * mid <= x && (mid+1)*(mid+1) >x) return (int)mid;
            if(mid*mid> x){
                right = mid;
            } else {
                left = mid;
            }
        }
    }


    // get from leetcode.
    // still slow, wtf..
    public int fastest(int x) {
        if (x == 0) return 0;

        // NOTE: start from max value, great idea
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            // NOTE: great idea to avoid overflow!
            // avoid left + right
            int mid = left + (right - left)/2;

            // notice -1 and +1 here.
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
