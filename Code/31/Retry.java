import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        // idea: scan backward, store the number until the numbers are not ascending
        if(nums == null || nums.length <= 1) return;
        int i = nums.length-1;
        for(; i>=1; i--) {
            if(nums[i-1] < nums[i]) {
                break;
            }
        }

        if(i==0) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        i--;
        // find the one to replace
        for(int j=nums.length-1; j>i; j--) {
            if(nums[j] > nums[i]) {
                swap(nums, i, j);
                break;
            }
        }

        reverse(nums, i+1, nums.length-1);
    }

    // start and end are inclusive
    public void reverse(int [] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}