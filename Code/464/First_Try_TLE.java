class Solution {
    // it seems that all this kind of problem should think in minmax method
    // first idea, maybe recusive dfs? minmax
    // try minmax without mem first
    // tle then try with mem
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0) return true;
        boolean [] chosen = new boolean[maxChoosableInteger];
        return canIWin(chosen, 0, desiredTotal);
    }

    public boolean canIWin(boolean [] chosen, int cur, int target) {
        if(cur >= target) return false;
        for(int i=0; i<chosen.length; i++) {
            if(!chosen[i]) {
                chosen[i] = true;
                // BUG 1: forget to use the add the not
                if(!canIWin(chosen, cur + i + 1, target)) {
                    // not sure whether we need to reset this.
                    // we do need this. Why? because the function is not converging instantly after return.
                    // In other words, we still need the correct chosen after return.
                    chosen[i] = false;
                    return true;
                }
                chosen[i] = false;
            }
        }
        return false;
    }

    //public Integer getKey()
}