import java.util.*;

class Solution {
    public boolean isPossible(int[] nums) {
        // kind of greedy idea

        // the sequence end with key, value is a queue of length
        // complexity: nlogn
        // fromLC, there are n solution
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int num : nums) {
            int insertLength;
            if(!map.containsKey(num-1) || map.get(num-1).size() == 0) {
                insertLength = 1;
            } else {
                insertLength = map.get(num-1).poll() + 1;
            }

            map.computeIfAbsent(num, (k) -> new PriorityQueue<Integer>()).add(insertLength);
        }

        // check
        for(PriorityQueue<Integer> pq : map.values()) {
            if(pq != null && !pq.isEmpty() && pq.peek() < 3) return false;
        }
        return true;
    }
}