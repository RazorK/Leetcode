class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return ;
        boolean asc = true;
        for(int i=0; i<nums.length - 1; i++) {
            if( asc && nums[i] > nums[i+1] || !asc && nums[i] < nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
            asc = !asc;
        }
    }
}