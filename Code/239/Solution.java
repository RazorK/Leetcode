class Solution {

    // when exclude the max, rescan for the max in the window
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        if(k==1) return nums;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<k; i++) {
            max = Math.max(nums[i], max);
        }

        int [] res = new int[nums.length - k + 1];
        res[0] = max;
        for(int i=k; i<nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
            } else {
                if(max == nums[i-k]) {
                    // BUG this part will cause err if k == 1, that's why we need to check k == 1 first.
                    max = Integer.MIN_VALUE;
                    for(int j=i-k+1; j<=i; j++) {
                        max = Math.max(nums[j], max);
                    };
                }
            }
            res[i-k+1] = max;
        }
        return res;
    }
}
