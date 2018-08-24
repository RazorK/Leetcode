import java.util.*;
class Solution {

    // BUG 1: the result doesn't have to be continous
    // NEW IDEA: DP, end with current, time complexity O(n^2)
    public int firstTry(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int [] map = new int [nums.length];
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int innerMax = -1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    innerMax = Math.max(innerMax, map[j]);
                }
            }
            int cur = innerMax == -1 ? 1 : innerMax+1;
            map[i] = cur;
            max = Math.max(max, cur);
        }

        return max;
    }

    // try NlogN
    // hard to think of a solution

    // idea from LC
    // the key is to find a index to apply binary search. From the abstract of this problem.

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int [] map = new int [nums.length];

        map[0] = nums[0];
        int end = 1;

        for(int i=1; i<map.length; i++)  {
            
        }
    }
}