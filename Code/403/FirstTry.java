class Solution {
    // first idea dfs
    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        for(int cur : stones) set.add(cur);
        int target = stones[stones.length-1];
        return dfsHelper(set, 0, 0, target);
    }

    public boolean dfsHelper(Set<Integer> stones, int curLength, int curStep, int target) {
        if(curLength == target) return true; 
        if(curLength > target) return false;
        if(curStep > 0 && stones.contains(curLength + curStep) && dfsHelper(stones, curLength + curStep, curStep, target)) return true;
        if(stones.contains(curLength + curStep + 1) && dfsHelper(stones, curLength + curStep + 1, curStep + 1, target)) return true;
        if(curStep - 1 > 0 && stones.contains(curLength + curStep - 1) && dfsHelper(stones, curLength + curStep - 1, curStep - 1, target)) return true;
        return false;
    }
}