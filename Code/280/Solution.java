import java.util.Arrays;

class Solution {
    // nlogn sort
    public void sort(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int [] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int left = 0, right = nums.length - 1;
        int cur = 0;
        while(left <= right) {
            nums[cur++] = copy[left];
            if(left!=right) nums[cur++] = copy[right];
            left++;
            right--;
        }
    }

    public void wiggleSort(int[] nums) {
        // the O(n) solution is easy to implement, the only thing is to prove that kind of array have a solution
        // in place
        if(nums == null || nums.length<=1) return;
        for(int i=0; i<nums.length-1; i++) {
            if(i%2==0) {
                if(nums[i] > nums[i+1]) swap(nums, i, i+1);
            } else {
                if(nums[i] < nums[i+1]) swap(nums, i, i+1);
            }
        }
    }

    public void swap(int [] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}