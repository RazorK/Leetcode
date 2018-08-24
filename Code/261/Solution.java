import java.util.*;

class Solution {
    public static boolean validGraph(int n, int [][] edges) {
        if(n <= 1) return true;
        if(edges.length != n-1) return false;

        //construct map
        List<HashSet<Integer>> map = new ArrayList<>();
        for(int i=0; i<n; i++) {
            map.add(new HashSet<Integer>);
        }
        for(int [] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // 1. acyclic, 2. no isolated nodes
        // dfs
        HashSet<Integer> global = new HashSet<>();
        boolean flag = validTree(map, 0, -1, new HashSet<Integer>(), global);
        return flag && global.size() == n;
    }

    public static boolean validTree(List<HashSet<Integer>> map, int cur, int parent, HashSet<Integer> visited, HashSet<Integer> global) {
        HashSet<Intger> nexts = map.get(cur);
        visited.add(cur);
        for(Integer next: nexts) {
            if(visited.contains(next) && next != parent) return false;
            if(next == parent) continue;
            if(!validTree(map, next, cur, visited)) return false;
        }
        visited.remove(cur);
        global.add(cur);
        return true;
    }
}