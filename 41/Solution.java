import java.util.*;
class Solution {
    //didn't think up any solution, look at the solution.
    // idea, constant space -> in place
    // !! O(n) -> bucket sort idea, the length of all the positive number is fixed.
    public static int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length;i++) {
            int index = nums[i];
            if(index-1<0 || index-1 >=nums.length) continue;
            while(index-1>=0 && index-1 < nums.length &&
             nums[index-1] != index) {
                swap(nums, i, index-1);
                index = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1) return i+1;
        }
        //System.out.println(Arrays.toString(nums));
        return nums.length+1;
    }

    public static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
