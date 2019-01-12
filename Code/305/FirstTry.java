import java.util.Map;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0) return res;
        Map<Integer, Integer> p = new HashMap<>();

        // construct p
        int cur = 0;
        for(int [] pos : positions) {
            int key = key(pos[0], pos[1]);
            if(!p.containsKey(key)) {
                p.put(key, key);
                cur ++;
            }

            int [] shifted = new int[] {-1, 0, 1, 0, -1};
            for(int i=0; i<4; i++) {
                int checkKey = key(pos[0] + shifted[i], pos[1] + shifted[i+1]);
                if(union(p, key, checkKey)) cur--;
            }
            res.add(cur);
        }
        return res;
    }

    public int findParent(Map<Integer, Integer> p, int key) {
        if(!p.containsKey(key)) return -1;
        while(p.get(key) != key) {
            key = p.get(key);
        }
        return key;
    }

    public boolean union(Map<Integer, Integer> p, int first, int second) {
        int fp = findParent(p, first);
        int sp = findParent(p, second);
        if(fp == -1 || sp == -1) return false;
        if(fp != sp) {
            p.put(fp, sp);
            return true;
        } else return false;
    }

    public int key(int m, int n) {
        return m*40000 + n;
    }
}