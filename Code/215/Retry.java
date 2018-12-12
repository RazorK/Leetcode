import java.util.*;
class Retry {
    public int findKthLargest(int[] nums, int k) {
        // try linear, constant space
        return recur(nums, k, 0, nums.length-1);
    }

    public int recur(int [] nums, int k, int start, int end) {
        if(start > end || k > end - start + 1) return -1;
        // rearrange, left = nums less than nums[start]
        int split = rearrange(nums, start, end);
        int left = split - start + 1;
        if(left == k) return nums[split];
        else if(left > k) {
            return recur(nums, k, start, split-1);
        } else {
            return recur(nums, k-left, split+1, end);
        }
    }

    public int rearrange(int [] nums, int left, int right) {
        if(nums == null || left >= right) return left; 
        int p = nums[left];
        while(left < right) {
            if(nums[right] <= p) {
                right --;
            } else {
                swap(nums, left, right);
                swap(nums, left + 1, right);
                left++;
            }
        }
        return left;
    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String [] args) {
        int [] in = {3,2,5,4,1};
        Retry s = new Retry();
        System.out.println(s.findKthLargest(in, 3));
    }
}