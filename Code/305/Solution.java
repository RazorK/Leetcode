import java.util.*;

class Solution {

    // try path compression;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0) return res;
        DSU dsu = new DSU();

        // construct p
        int cur = 0;
        for(int [] pos : positions) {
            int key = key(pos[0], pos[1]);
            cur += dsu.initKey(key);

            int [] shifted = new int[] {-1, 0, 1, 0, -1};
            for(int i=0; i<4; i++) {
                int checkKey = key(pos[0] + shifted[i], pos[1] + shifted[i+1]);
                if(dsu.union(key, checkKey)) cur--;
            }
            res.add(cur);
        }
        return res;
    }

    public class DSU {
        Map<Integer, Integer> p;
        public DSU() {
            p = new HashMap<>();
        }

        public int findParent(int key) {
            int ori = key;
            while(key != p.get(key)) key = p.get(key);

            while(ori != p.get(ori)) {
                int next = p.get(ori);
                p.put(ori, key);
                ori = next;
            }

            return key;
        }

        public int initKey(int k) {
            if(!p.containsKey(k)) {
                p.put(k, k);
                return 1;
            }
            return 0;
        }

        public boolean union(int l, int r) {
            if(!p.containsKey(l) || !p.containsKey(r)) return false;
            int lp = findParent(l);
            int rp = findParent(r);

            if(lp != rp) {
                p.put(lp, rp);
                return true;
            } return false;
        }
    }

    public int key(int x, int y) {
        return x * 40000 + y;
    }
}