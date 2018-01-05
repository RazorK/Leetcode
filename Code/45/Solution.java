class Solution {
    static int min = Integer.MAX_VALUE;

    // First idea, DFS, keep a min integer
    // time limit exceed....
    public static int jump(int[] nums) {
        min = Integer.MAX_VALUE;
        dfs(nums, 0, -1);
        return min;
    }

    public static void dfs(int [] nums, int index, int curStep){
        curStep = curStep+1;
        if(index>=nums.length-1) {
            if(curStep<min) min = curStep;
            return;
        }
        for(int i=1; i<=nums[index]; i++) {
            dfs(nums, index+i, curStep);
        }
    }

    // Insipired by the greedy algorithm
    // Second Try, just find the max next step, and keep finding max
    // basically linear
    public static int second(int[] nums) {
        if(nums.length == 0 ) return 0;
        int start = 0, end = 0;
        int step = 0;
        while(end<nums.length-1) {
            step++;
            int max = 0;
            for(int i = start; i <= end; i++) {
                // bug here, add a "+ 1" by mistake
                int temp = i + nums[i];
                if(temp>max) max = temp;
            }
            start = end+1;
            end = max;
        }
        return step;
    }
}
