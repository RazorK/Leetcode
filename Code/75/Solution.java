import java.util.*;
class Solution {
    // Given an array with n objects colored red, white or blue, sort them so that
    // objects of the same color are adjacent, with the colors in the order red, white and blue.
    //
    // Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    //
    // Note:
    // You are not suppose to use the library's sort function for this problem.

    // although the problem require not to use the count and reconstruct solution.
    // but still want to try lol.
    public static void sortColors(int[] nums) {
        int [] board = new int [3];
        Arrays.fill(board, 0);
        for(int num : nums) {
            board[num] ++;
        }
        //System.out.println(Arrays.toString(board));
        int ptr = 0;
        // BUG no need to reconstruct an array result, the problem require to be solve in place
        for(int i=0; i<nums.length; i++) {
            while(board[ptr] == 0) ptr++;
            board[ptr]--;
            nums[i] = ptr;
        }
        //System.out.println(Arrays.toString(nums));
    }

    // because the problem is simplified, we can not actually recreate the instance for the real problem
    // so here I want to follow the requirement and try to solve it.

    // implement by swap
    public static void realSolution(int[] nums) {
        if(nums.length == 0) return;

        int start = 0, end = nums.length - 1, ptr = 0;
        // BUG forget equals here, notice here equal means when equal process it.
        while(ptr<=end) {
            if(nums[ptr] == 0) {
                if(start != ptr)
                    swap(nums, start, ptr);
                ptr++;
                start++;
            } else if(nums[ptr] == 2) {
                swap(nums, ptr, end);
                end--;
            } else {
                ptr++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
