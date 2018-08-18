import java.util.*;
public class Solution {
    public static int lengthOfLIS(int [] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int [] board = new int [nums.length];
        board[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++) {
            int cur = nums[i];
            int interMax = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] < cur) interMax = Math.max(interMax, board[j]);
            }
            board[i] = interMax+1;
            max=Math.max(interMax+1, max);
        }
        return max;
    }

    public static void main(String [] args) {
        // System.out.println(lengthOfLIS(new int [] {4,5,6,7,1,2,3,204}));
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(1,4);
        System.out.println(x.toString());
    }
}
