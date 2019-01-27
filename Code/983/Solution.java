import java.util.*;
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp idea
        int [] board = new int [days.length];
        board[0] = costs[0];

        // try linear find first
        for(int i=1; i<board.length; i++) {
            int can1 = board[i-1] + costs[0];
            
            // can2 find 7 days before;
            int it = i-1;
            while(it >= 0 && days[i] - days[it] <= 6) it--;
            int can2 = costs[1] + (it >= 0 ? board[it] : 0);

            // can3 find 30 days before;
            while(it >= 0 && days[i] - days[it] <= 29) it--;
            int can3 = costs[2] + (it >= 0 ?  board[it] : 0);

            board[i] = Math.min(can1, Math.min(can2, can3));
        }

        return board[board.length-1];
    }
}