import java.util.*;
class Solution {
    // try minmax dfs with mem this time.

    // I just remember this from last time I see this problem:
    // once chosen is fixed, the curValue is fixed, that's why we can use mem with chosen only
    // but not cross product of chosen and cur

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0) return true;
        // BUG 1: check whether there can be a winner
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return canIWin(new boolean[maxChoosableInteger], 0, desiredTotal, new HashMap<Integer, Boolean>());
    }

    public boolean canIWin(boolean [] chosen, int cur, int target, Map<Integer, Boolean> mem) {
        if(cur >= target) return false;

        // check mem
        int key = getKey(chosen);
        if(mem.containsKey(key)) return mem.get(key);

        // minmax
        for(int i=0; i<chosen.length; i++) {
            if(!chosen[i]) {
                chosen[i] = true;
                if(!canIWin(chosen, cur +i + 1, target, mem)) {
                    chosen[i] = false;
                    mem.put(key, true);
                    return true;
                }
                chosen[i] = false;
            }
        }

        mem.put(key, false);
        return false;
    }

    public int getKey(boolean [] c) {
        int res = 0;
        for(int i=0; i<c.length; i++) {
            if(c[i]) res += 1 << i;
        }
        return res;
    }
}