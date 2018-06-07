class Solution {
    // Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
    //
    // Example 1:
    //
    // Input: [2,3,-2,4]
    // Output: 6
    // Explanation: [2,3] has the largest product 6.
    // Example 2:
    //
    // Input: [-2,0,-1]
    // Output: 0
    // Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

    // first try, pass two values when go through
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int total_max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num == 0) {
                total_max = Math.max(total_max, 0);
                max = 1;
                min = 1;
                continue;
            }

            // BUG, forget to compare to itself. each value can choose itself only
            if(num > 0) {
                min = Math.min(min * num, num);
                max = Math.max(max * num, num);
            } else if(num < 0) {
                int min_temp = min;
                min = Math.min(max * num, num);
                max = Math.max(min_temp * num, num);
            }
            total_max = Math.max(max, total_max);
        }
        return total_max;
    }

    // IDEA from leetcode is really hard to think of..
    // proof: the max must be in this format: one side of it is 0 or end, the other is neg or 0.
    // can not be both neg, can not include pos.
    //
    // So we can scan forward and scan backward, and choose the max.
    public int fromLC(int[] a) {
        if (a == null || a.length == 0) return 0;
        if (a.length == 1) return a[0];

        int maxForward = Integer.MIN_VALUE;
        int maxBackward = Integer.MIN_VALUE;

        int maxSoFar = 1;

        int n = a.length;

        for (int i = 0; i < n; i++) {
            maxSoFar *= a[i];

            if (maxSoFar == 0) {
                maxSoFar = 1;
                continue;
            }

            maxForward = Math.max(maxForward, maxSoFar);
        }

        maxSoFar = 1;

        for (int i = n-1; i >= 0; i--) {
            maxSoFar *= a[i];

            if (maxSoFar == 0) {
                maxSoFar = 1;
                continue;
            }

            maxBackward = Math.max(maxBackward, maxSoFar);
        }

        int res = Math.max(maxForward, maxBackward);

        return Math.max(res, 0);
    }

}
