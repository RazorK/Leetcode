/**
 * input: rotated array(1,2,3,4,5->4,5,1,2,3), target integer
 * output: index of the integer, -1 if not found
 *
 * Created by aimin on 2017/8/20.
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int start = nums[0];
        int cur,last;
        if(target>start) {
            last = 0;
            for(int i=1;i<nums.length;i++) {
                cur = nums[i];
                if(target == cur) return i;
                if(cur<last) return -1;
                last = cur;
            }
            return -1;
        } else if(target<start) {
            last = Integer.MAX_VALUE;
            for(int i=nums.length-1;i>=1;i--) {
                cur = nums[i];
                if(target==cur) return i;
                if(cur>last) return -1;
                last = cur;
            }
            return -1;
        } else return 0;
    }

    /**
     * leetcode fastest algorithm
     * dichotomy, divide into two parts until found the target
     * @param nums
     * @param target
     * @return
     */
    public int fastest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while(left +1 < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left  = mid + 1;
                }
            }
            if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
