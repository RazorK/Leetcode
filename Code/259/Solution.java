class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <=2) return 0;
        Arrays.sort(nums);

        // idea two pointers
        int res = 0;
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    res += right-left;
                    left++;
                } else {
                // BUG try to add res here, which is very tedious to do 
                // Because thinks in a reverse way.
                    right--;
                }
            }
        }
        return res;
    }
}