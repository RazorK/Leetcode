import java.util.*;
class Solution {

    // first idea, Sort and record how much I need.
    // TLE...
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> required = new HashMap<>();

        for(int cur : hand) {
            if(!required.containsKey(cur)) {
                for(int i=1; i<W; i++) {
                    required.put(i+cur, required.getOrDefault(i+cur, 0) + 1);
                } 
            } else {
                if(required.get(cur) == 1) required.remove(cur);
                else required.put(cur, required.get(cur) - 1);
            }
        }
        return required.size() == 0;
    }

    // idea from LC
    // 1. use treemap to sort and count at the same time
    // 2. handle all the card of the same value one time, rather than iterate hand.
    public boolean fromLC(int [] hand, int W) {
        if(hand.length % W != 0 ) return false;

        Map<Integer, Integer> map = new TreeMap<>();

        for(int cur : hand) map.put(cur, map.getOrDefault(cur, 0) + 1);

        for(int cur : map.keySet()) {
            int num = map.get(cur);
            if(num == 0) continue;
            if(num > 0) {
                for(int i=1; i<W; i++) {
                    if(!map.containsKey(cur+i) || map.get(cur+i) < num) return false;
                    map.put(cur+i, map.get(cur+i) - num);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // actually I think this is not correct...
    public boolean wtf(int [] hand, int W) {
        int temp[] = new int[W];
        for(int h : hand)
        {
            temp[h%W]++;
        }
        
        int c = temp[0];
        for(int i = 1 ; i < W; i++)
        {
            if(temp[i] != c)
            {
                return false;
            }
        }
        return true;
    }
}