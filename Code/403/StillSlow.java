import java.util.*;
class Solution {
    public boolean canCross(int[] stones) {
        // try dp
        // each set contains step that can reach this stone
        List<Set<Integer>> board = new ArrayList<>();

        for(int i=0; i<stones.length; i++) board.add(new HashSet<>());
        board.get(0).add(0);
        for(int i=1; i<stones.length; i++) {
            Set<Integer> cur = board.get(i);
            for(int j=0; j<i; j++) {
                int gap = stones[i] - stones[j];
                Set<Integer> set = board.get(j);
                if(set.contains(gap) || set.contains(gap - 1) || set.contains(gap + 1)) {
                    cur.add(gap);
                }
            }
        }

        return board.get(stones.length-1).size() != 0;
    }
    
}