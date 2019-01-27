import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // is there any greedy or DP solution?
        
        // greedy
        // use a priorityqueue, everytime we find the farest station to fuel until we reach the end
        // one more thing to simplify the thinking: curPostion and curFuel can be conbine together
        // we don't care the current position, we only care whether pos+fuel exceed that target

        int curVal = startFuel;
        int count = 0;
        int ptr = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(true) {
            if(curVal >= target) return count;

            while(ptr < stations.length && stations[ptr][0] <= curVal) {
                pq.add(stations[ptr++][1]);
            }

            if(pq.isEmpty()) return -1;

            curVal += pq.poll();
            count ++;
        }
    }
}