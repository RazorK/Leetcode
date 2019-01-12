class Solution {
    // TLE, try other thinking then.
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // looks like NP hard, try dfs first
        dfs(startFuel, 0, 0, 0, target, stations);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int min = Integer.MAX_VALUE;
    public void dfs(int curFuel, int curPos, int nextStId, int count, int target, int [][] stations) {
        if(nextStId >= stations.length) {
            if(target - curPos <= curFuel) min = Math.min(min, count);
            return;
        }

        // try reach the next station
        int nextPos = stations[nextStId][0], nextFuel = stations[nextStId][1];
        if(curFuel + curPos < nextPos) return;

        // go in both direction
        // not add fuel
        dfs(curFuel + curPos - nextPos, nextPos, nextStId + 1, count, target, stations);
        dfs(curFuel + curPos - nextPos + nextFuel, nextPos, nextStId + 1, count + 1, target, stations);
    }
}