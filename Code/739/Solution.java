class Solution {

    // typical decreasing stack
    public int[] dailyTemperatures(int[] T) {
        int [] stack = new int [T.length];
        int ptr = 0;

        int [] res = new int [T.length];

        for(int i=0; i<T.length; i++) {
            int cur = T[i];
            while(ptr != 0 && T[stack[ptr - 1]] < cur) {
                int pop = stack[ptr - 1];
                res[pop] = i-pop;
                ptr--;
            }
            stack[ptr ++] = i;
        }

        return res;
    }
}