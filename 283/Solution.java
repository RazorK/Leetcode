class Solution {

    // bitterly painful..
    // see you facebook T T
    public void moveZeroes(int[] nums) {
        int front=0, behind = 0;
        int temp, frontv, behindv;
        frontv = nums[front];
        behindv = nums[behind];
        while(behind<=nums.length-1 && front<=nums.length-1) {
            frontv = nums[front];
            behindv = nums[behind];
            if(frontv != 0) {
                if(front == nums.length-1) break;
                frontv = nums[++front];
                continue;
            }
            if(behind < front) {
                behind = front;
                behindv = nums[front];
            }
            if(behindv ==0) {
                if(behind == nums.length-1) break;
                behindv = nums[++behind];
                continue;
            }
            nums[front++] = behindv;
            nums[behind++] = frontv;
        }
    }

    // faster
    // just use two pointers.
    // find all positive numbers and rearrange them to left
    // put other zero.
    public void howtothinkup(int[] nums) {
        int left = 0, i = 0;
        for(; i < nums.length; i++)
            if(nums[i] != 0) nums[left++] = nums[i];
        for(int j = left; j < nums.length; j++)
            nums[j] = 0;
    }
}
