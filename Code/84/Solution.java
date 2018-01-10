import java.util.*;
class Solution {
    // Given n non-negative integers representing the histogram's bar height where
    // the width of each bar is 1, find the area of largest rectangle in the histogram.
    //
    //
    // Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
    //
    //
    // The largest rectangle is shown in the shaded area, which has area = 10 unit.
    //
    // For example,
    // Given heights = [2,1,5,6,2,3],
    // return 10.

    // try to solve by dp.
    // NOTE get a idea, track the lowest number in all the range(n^2)
    // n^2 solution
    // still time limit exceed...
    public int tryDP(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        // keep the lowest number in heights
        int [][] board = new int[heights.length][heights.length];
        // init the board
        for(int i=0; i<heights.length; i++) {
            board[i][i] = heights[i];
        }

        // finish all the board;
        for(int i=0; i<heights.length; i++) {
            for(int j=i+1; j<heights.length; j++) {
                if(heights[j] < board[i][j-1])
                    board[i][j] = heights[j];
                else
                    board[i][j] = board[i][j-1];
            }
        }

        // get the max
        int max = 0;
        for(int i=0; i<heights.length; i++) {
            for(int j=i; j<heights.length; j++) {
                int temp = (j-i+1) * board[i][j];
                if(temp > max)
                    max = temp;
            }
        }
        return max;
    }

    // try to think a faster way
    // still worst case n^2
    // still exceed time limit
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] board = new int[length];
        //right scan
        for(int i=0; i<length; i++) {
            int ptr = i+1;
            int temp = heights[i];
            while(ptr<heights.length){
                if(heights[ptr]<temp) {
                    break;
                }
                board[i]+=temp;
                ptr++;
            }
        }

        //left scan
        for(int i=length-1; i>=0; i--) {
            int ptr = i-1;
            int temp = heights[i];
            while(ptr>=0) {
                if(heights[ptr] < temp) break;
                board[i]+=temp;
                ptr--;
            }
        }

        int max = 0;
        for(int i=0; i<length; i++) {
            board[i] += heights[i];
            if(board[i]>max) max = board[i];
        }
        return max;
    }

    // give up, check answer..
    // link1 https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
    // divide and conquer
    // find the minimum, and result = max(left, min*length, right).

    // link2 https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    // link3 https://www.youtube.com/watch?v=VNbkzsnllsU
    // NOTE basic idea, for each bar, find the left index and right index between which
    //  this bar is the minimum.
    // the first and second solution above are rough solutions based on this idea.
    // we can use stack to solve this in linear time.

    // NOTE the really magic idea is this, use the stack to record the possibility of rectangle we
    //  can have, and the time to calculate the area is when we encounter a bar smaller than this one.

    //  what's more, the really cool part is it can also tract the starting point !!? because any earlier
    //  bigger bar is already removed.

    // so by using the stack, for each bar, in linear time, we can get the first left smaller index
    // and the first right smaller index.

    public int tryRecite(int [] heights) {
        if(heights == null || heights.length == 0) return 0;
        int max = 0;
        // BUG the stack is for remembering the index rather than height. which save us a stack.
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=heights.length; i++) {
            // add the last to calculate the left in the stack.
            int temp = (i==heights.length ? 0 : heights[i]);
            if(st.empty()|| temp>heights[st.peek()]) {
                st.push(i);
                continue;
            }
            // here use i-- and pass is a great idea, but I will try not use it first.
            while(!st.empty() && temp < heights[st.peek()]) {
                int min = heights[st.pop()];
                System.out.println("min: "+ min);
                System.out.println((i - (st.empty() ? 0 : (st.peek()+1))));
                max = Math.max(max, min*(i - (st.empty() ? 0 : (st.peek()+1))));
            }
            st.push(i);
        }
        return max;
    }


    public int fromLC(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }


    // use Stack type seems really slow, so try to rewrite it by array.
    // much faster and no idea why.
    public int tryArray(int [] heights) {
        if(heights == null || heights.length == 0) return 0;
        int max = 0;
        // BUG the stack is for remembering the index rather than height. which save us a stack.
        int [] st = new int[heights.length+1];
        int ptr = 0;
        for(int i=0; i<=heights.length; i++) {
            // add the last to calculate the left in the stack.
            int temp = (i==heights.length ? 0 : heights[i]);
            if(ptr == 0 || temp>heights[st[ptr-1]]) {
                st[ptr++] = i;
                continue;
            }
            // here use i-- and pass is a great idea, but I will try not use it first.
            while(!(ptr == 0) && temp < heights[st[ptr-1]]) {
                int min = heights[st[--ptr]];
                max = Math.max(max, min*(i - (ptr == 0 ? 0 : (st[ptr-1]+1))));
            }
            st[ptr++] = i;
        }
        return max;
    }
}
